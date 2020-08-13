package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.IntegerResult;

public class GroupsDeleteAddress extends GetMethod<IntegerResult> {
	private static final String GROUP_ID = "group_id";
	private static final String ADDRESS_ID = "address_id";

	public GroupsDeleteAddress setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public GroupsDeleteAddress setAddressId(int addressId) {
		params.put(ADDRESS_ID, addressId);
		return this;
	}

	public GroupsDeleteAddress(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.DELETE_ADDRESS;
	}

	@Override
	protected JsonToPojoConverter<IntegerResult> getConverter() {
		return GenericConverterFactory.get(IntegerResult.class);
	}
}