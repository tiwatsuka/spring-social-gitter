package org.springframework.social.gitter.api;

import java.util.List;

public interface MessagesOperations {
	
	List<Message> listMessages(String roomId);
	
	List<Message> listMessages(String roomId, int skip, String beforeId, String afterId, String aroundId, int limit, String query);

	Message getMessage(String roomId, String messageId);
	
	Message sendMessage(String roomId, String message);
	
	void updateMessage(String roomId, String messageId, String message);
}
