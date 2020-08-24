package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetById extends GetMethod<GenericResult<VkList<Message>>> {
    private List<Integer> messageIds;
    private Integer previewLength;
    private Boolean extended;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetById(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetById();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<Message>>> getConverter() {
        return  GenericConverterFactory.get(new TypeToken<GenericResult<VkList<Message>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_ids", messageIds),
                keyVal("preview_length", previewLength),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public MessagesGetById setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public Integer getPreviewLength() {
        return previewLength;
    }

    public MessagesGetById setPreviewLength(Integer previewLength) {
        this.previewLength = previewLength;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetById setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}