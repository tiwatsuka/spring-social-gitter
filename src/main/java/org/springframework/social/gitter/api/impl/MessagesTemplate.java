package org.springframework.social.gitter.api.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.Message;
import org.springframework.social.gitter.api.MessagesOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class MessagesTemplate implements MessagesOperations {

	private final Gitter gitter;
	
	private RestTemplate restTemplate;
	
	public MessagesTemplate(Gitter gitter, RestTemplate restTemplate) {
		this.gitter = gitter;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Message> listMessages(String roomId) {
		return listMessages(roomId, 0, null, null, null, 0, null);
	}

	@Override
	public List<Message> listMessages(String roomId, int skip, String beforeId, String afterId, String aroundId, int limit,
			String query) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "chatMessages");
		if (StringUtils.hasLength(query)) {
			uriBuilder.queryParam("q", query);
		}
		if (StringUtils.hasLength(beforeId)) {
			uriBuilder.queryParam("beforeId", beforeId);
		}
		if (StringUtils.hasLength(afterId)) {
			uriBuilder.queryParam("afterId", afterId);
		}
		if (StringUtils.hasLength(aroundId)) {
			uriBuilder.queryParam("aroundId", aroundId);
		}
		if (skip != 0) {
			uriBuilder.queryParam("skip", skip);
		}
		if (limit != 0) {
			uriBuilder.queryParam("limit", limit);
		}
		ResponseEntity<Message[]> messages = restTemplate.getForEntity(uriBuilder.toString(), Message[].class);
		return Arrays.asList(messages.getBody());
	}

	@Override
	public Message getMessage(String roomId, String messageId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "chatMessages", messageId);
		return restTemplate.getForObject(uriBuilder.toUriString(), Message.class);
	}

	@Override
	public Message sendMessage(String roomId, String message) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "chatMessages");
		Map<String, String> request = new HashMap<String,String>();
		request.put("text", message);
		return restTemplate.postForObject(uriBuilder.toUriString(), request, Message.class);
	}

	@Override
	public void updateMessage(String roomId, String messageId, String message) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "chatMessages", messageId);
		Map<String, String> request = new HashMap<String,String>();
		request.put("text", message);
		restTemplate.put(uriBuilder.toUriString(), request);
	}

}
