package org.springframework.social.gitter.api;

import java.util.List;

public interface UserOperations {

	public User getCurrentUser();
	
	public List<Room> listUserRooms(String userId);
	
	public List<Room> listUserChannels(String userId);
	
}
