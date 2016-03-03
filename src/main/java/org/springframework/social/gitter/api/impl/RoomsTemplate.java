package org.springframework.social.gitter.api.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.Room;
import org.springframework.social.gitter.api.RoomsOperations;
import org.springframework.social.gitter.api.User;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RoomsTemplate implements RoomsOperations {
	
	private final Gitter gitter;
	
	private RestTemplate restTemplate;
	
	public RoomsTemplate(Gitter gitter, RestTemplate restTemplate) {
		this.gitter = gitter;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Room> listRooms() {
		return listRooms(null);
	}

	@Override
	public List<Room> listRooms(String query) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).path("rooms");
		if (StringUtils.hasLength(query)) {
			uriBuilder.queryParam("q", query);
		}
		return fetchList(uriBuilder, Room[].class);
	}

	@Override
	public List<User> users(String roomId) {
		return users(roomId, null, 0, 0);
	}
	
	@Override
	public List<User> users(String roomId,String query, int skip, int limit) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "users");
		if (StringUtils.hasLength(query)) {
			uriBuilder.queryParam("q", query);
		}
		if (skip != 0) {
			uriBuilder.queryParam("skip", skip);
		}
		if (limit != 0) {
			uriBuilder.queryParam("limit", limit);
		}
		return fetchList(uriBuilder, User[].class);
	}

	@Override
	public List<Room> channels(String roomId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "channels");
		return fetchList(uriBuilder, Room[].class);
	}
	
	private <T> List<T> fetchList(UriComponentsBuilder builder, Class<T[]> type){
		ResponseEntity<T[]> response = restTemplate.getForEntity(builder.build().toUriString(), type);
		List<T> body = Arrays.asList(response.getBody());
		return body;
	}

	@Override
	public Room join(String uri) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).path("rooms");
		Map<String, String> request = new HashMap<String,String>();
		request.put("uri", uri);
		return restTemplate.postForObject(uriBuilder.toUriString(), request, Room.class);
	}

	@Override
	public void removeUser(String roomId, String userId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId, "users", userId);
		restTemplate.delete(uriBuilder.toUriString());
	}

	@Override
	public void update(String roomId, String topic, boolean noindex, String tag) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId);
		UpdateRequest request = new UpdateRequest(topic, noindex, tag);
		restTemplate.put(uriBuilder.toUriString(), request);
	}

	@Override
	public void delete(String roomId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("rooms", roomId);
		restTemplate.delete(uriBuilder.toUriString());
	}
	
	private class UpdateRequest{
		private String topic;
		private boolean noindex;
		private String tag;
		public UpdateRequest(String topic, boolean noindex, String tag){
			this.topic = topic;
			this.noindex = noindex;
			this.tag = tag;
		}
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public boolean isNoindex() {
			return noindex;
		}
		public void setNoindex(boolean noindex) {
			this.noindex = noindex;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
	}
	
}
