package api.longpoll.bots.methods;

public class VkApi {
	private static final String URL = "https://api.vk.com/method/";

	public static class Groups {
		private static final String METHOD = URL.concat("groups.");
		public static final String GET_LONG_POLL_SERVER = METHOD.concat("getLongPollServer");
		public static final String ADD_ADDRESS = METHOD.concat("addAddress");
		public static final String DELETE_ADDRESS = METHOD.concat("deleteAddress");
		public static final String ADD_CALLBACK_SERVER = METHOD.concat("addCallbackServer");
		public static final String GET_BANNED = METHOD.concat("getBanned");
		public static final String GET_BY_ID = METHOD.concat("getById");
		public static final String GET_MEMBERS = METHOD.concat("getMembers");
		public static final String IS_MEMBER = METHOD.concat("isMember");
	}

	public static class Messages {
		private static final String METHOD = URL.concat("messages.");
		public static final String SEND = METHOD.concat("send");
		public static final String CREATE_CHAT = METHOD.concat("createChat");
		public static final String DELETE = METHOD.concat("delete");
		public static final String DELETE_CHAT_PHOTO = METHOD.concat("deleteChatPhoto");
		public static final String DELETE_CONVERSATION = METHOD.concat("deleteConversation");
		public static final String EDIT = METHOD.concat("edit");
		public static final String GET_BY_CONVERSATION_MESSAGE_ID = METHOD.concat("getByConversationMessageId");
		public static final String EDIT_CHAT = METHOD.concat("editChat");
		public static final String GET_BY_ID = METHOD.concat("getById");
		public static final String GET_CONVERSATION_MEMBERS = METHOD.concat("getConversationMembers");
		public static final String GET_CONVERSATIONS = METHOD.concat("getConversations");
		public static final String GET_CONVERSATIONS_BY_ID = METHOD.concat("getConversationsById");
		public static final String GET_HISTORY = METHOD.concat("getHistory");
		public static final String GET_HISTORY_ATTACHMENTS = METHOD.concat("getHistoryAttachments");
		public static final String GET_INVITE_LINK = METHOD.concat("getInviteLink");
		public static final String PIN = METHOD.concat("pin");
		public static final String RESTORE = METHOD.concat("restore");
		public static final String REMOVE_CHAT_USER = METHOD.concat("removeChatUser");
		public static final String SEARCH_CONVERSATIONS = METHOD.concat("searchConversations");
		public static final String MARK_AS_ANSWERED_CONVERSATION = METHOD.concat("markAsAnsweredConversation");
		public static final String MARK_AS_IMPORTANT_CONVERSATION = METHOD.concat("markAsImportantConversation");
		public static final String MARK_AS_READ = METHOD.concat("markAsRead");
	}

	public static class Photos {
		private static final String METHOD = URL.concat("photos.");
		public static final String GET_MESSAGE_UPLOAD_SERVER = METHOD.concat("getMessagesUploadServer");
		public static final String SAVE_MESSAGES_PHOTO = METHOD.concat("saveMessagesPhoto");
		public static final String GET_OWNER_COVER_PHOTO_UPLOAD_SERVER = METHOD.concat("getOwnerCoverPhotoUploadServer");
		public static final String SAVE_OWNER_COVER_PHOTO = METHOD.concat("saveOwnerCoverPhoto");
	}

	public static class Docs {
		private static final String METHOD = URL.concat("docs.");
		public static final String GET_MESSAGES_UPLOAD_SERVER = METHOD.concat("getMessagesUploadServer");
		public static final String SAVE = METHOD.concat("save");
		public static final String GET_WALL_UPLOAD_SERVER = METHOD.concat("getWallUploadServer");
		public static final String SEARCH = METHOD.concat("search");
	}

	public static class Board {
		private static final String METHOD = URL.concat("board.");
		public static final String DELETE_COMMENT = METHOD.concat("deleteComment");
		public static final String RESTORE_COMMENT = METHOD.concat("restoreComment");
	}

	public static class Wall {
		private static final String METHOD = URL.concat("wall.");
		public static final String CLOSE_COMMENTS = METHOD.concat("closeComments");
		public static final String OPEN_COMMENTS = METHOD.concat("openComments");
		public static final String CREATE_COMMENT = METHOD.concat("createComment");
	}

	public static class Users {
		private static final String METHOD = URL.concat("users.");
		public static final String GET = METHOD.concat("get");
	}
}
