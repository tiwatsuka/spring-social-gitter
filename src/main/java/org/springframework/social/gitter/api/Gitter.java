package org.springframework.social.gitter.api;

import org.springframework.social.ApiBinding;

public interface Gitter extends ApiBinding{

	RoomsOperations roomsOperations();
	
	MessagesOperations messagesOperations();
	
	UserOperations userOperations();
	
	String getApiBaseUrl();
	
}
