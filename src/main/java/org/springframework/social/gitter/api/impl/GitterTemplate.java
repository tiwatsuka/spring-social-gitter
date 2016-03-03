package org.springframework.social.gitter.api.impl;

import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.MessagesOperations;
import org.springframework.social.gitter.api.RoomsOperations;
import org.springframework.social.gitter.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class GitterTemplate extends AbstractOAuth2ApiBinding implements Gitter {

	private RoomsOperations roomsOperations;
	
	private MessagesOperations messagesOperations;
	
	private UserOperations userOperations;
	
	public GitterTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	private void initialize(){
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
	
	private void initSubApis(){
		roomsOperations = new RoomsTemplate(this, getRestTemplate());
		messagesOperations = new MessagesTemplate(this, getRestTemplate());
	}
	
	@Override
	public RoomsOperations roomsOperations() {
		return roomsOperations;
	}

	@Override
	public MessagesOperations messagesOperations() {
		return messagesOperations;
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	public String getApiBaseUrl() {
		return "https://api.gitter.im/v1/";
	}

}
