package org.springframework.social.gitter.api.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.Room;
import org.springframework.social.gitter.api.User;
import org.springframework.social.gitter.api.UserOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class UserTemplate implements UserOperations {

	private final Gitter gitter;
	
	private RestTemplate restTemplate;
	
	public UserTemplate(Gitter gitter, RestTemplate restTemplate) {
		this.gitter = gitter;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public User getCurrentUser() {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).path("user");
		List<User> users = fetchList(uriBuilder, User[].class);
		return users.get(0);
	}

	@Override
	public List<Room> listUserRooms(String userId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("user",userId,"rooms");
		return fetchList(uriBuilder, Room[].class);
	}

	@Override
	public List<Room> listUserChannels(String userId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(gitter.getApiBaseUrl()).pathSegment("user",userId,"channels");
		return fetchList(uriBuilder, Room[].class);
	}
	
	private <T> List<T> fetchList(UriComponentsBuilder builder, Class<T[]> type){
		ResponseEntity<T[]> response = restTemplate.getForEntity(builder.build().toUriString(), type);
		List<T> body = Arrays.asList(response.getBody());
		return body;
	}
}
