package api.longpoll.bots.converters.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.messages.MessagesSendResult;
import com.google.common.reflect.TypeToken;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class MessagesSendResultConverterIpml extends JsonToPojoConverter<MessagesSendResult> {
	private static final String RESPONSE_FIELD = "response";

	@Override
	public MessagesSendResult convert(JsonObject jsonObject) {
		MessagesSendResult messagesSendResult = gson.fromJson(jsonObject, MessagesSendResult.class);
		JsonElement element = jsonObject.get(RESPONSE_FIELD);
		return messagesSendResult.setResponse(element.isJsonPrimitive()
				? element.getAsInt()
				: gson.fromJson(element, new TypeToken<List<MessagesSendResult.Response>>(){}.getType()));
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Object.class.equals(fieldAttributes.getDeclaredClass());
	}
}