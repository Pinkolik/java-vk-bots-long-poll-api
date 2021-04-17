package api.longpoll.bots.server;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.Converter;
import api.longpoll.bots.converters.StringToJsonConverter;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.methods.events.GetEvents;
import api.longpoll.bots.methods.groups.GroupsGetLongPollServer;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResponse;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LongPollClient implements Client {
    private static final Logger log = LoggerFactory.getLogger(LongPollClient.class);
    private static final int ATTEMPTS = 10;

    private static final Converter<String, JsonObject> STRING_TO_JSON_CONVERTER = new StringToJsonConverter();
    private GroupsGetLongPollServer groupsGetLongPollServer;
    private GetEvents getEvents;

    public LongPollClient(LongPollBot bot) {
        groupsGetLongPollServer = new GroupsGetLongPollServer(bot.getAccessToken()).setGroupId(bot.getGroupId());
        getEvents = new GetEvents(bot.getAccessToken());
    }

    @Override
    public List<Event> getUpdates() throws BotsLongPollAPIException, BotsLongPollException {
        for (int attempt = 0; attempt < ATTEMPTS; attempt++) {
            log.debug("Getting events from VK Long Poll Server. Attempt: {}.", attempt + 1);
            try {
                GetEventsResult getEventsResult = getEvents.execute();
                getEvents.setTs(getEventsResult.getTs());
                return getEventsResult.getEvents();
            } catch (BotsLongPollException e) {
                tryHandle(e);
            }
        }
        throw new BotsLongPollException("Failed to get events from Long Poll server. Number of attempts: " + ATTEMPTS);
    }

    public void init() throws BotsLongPollAPIException, BotsLongPollException {
        GroupsGetLongPollServerResponse response = groupsGetLongPollServer.execute().getResponse();
        getEvents.setServer(response.getServer())
                .setKey(response.getKey())
                .setTs(response.getTs());
    }

    protected void tryHandle(BotsLongPollException e) throws BotsLongPollException, BotsLongPollAPIException {
        log.warn("Failed to get events from VK Long Poll Server.", e);
        JsonObject jsonObject = STRING_TO_JSON_CONVERTER.convert(e.getMessage());

        if (!jsonObject.has("failed")) {
            throw e;
        }

        int code = jsonObject.get("failed").getAsInt();
        switch (code) {
            case 1:
                getEvents.setTs(jsonObject.get("ts").getAsInt());
                break;
            case 2:
            case 3:
                init();
                break;
        }
    }
}