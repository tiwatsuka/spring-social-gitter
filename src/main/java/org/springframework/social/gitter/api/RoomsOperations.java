package org.springframework.social.gitter.api;

import java.util.List;

public interface RoomsOperations {

	List<Room> listRooms();
	
	List<Room> listRooms(String query);
	
	List<User> users(String roomId); 
	
	List<User> users(String roomId, String query, int skip, int limit);
	
	List<Room> channels(String roomId);
	
	Room join(String uri);
	
	void removeUser(String roomId, String userId);
	
	void update(String roomId, String topic, boolean noindex, String tag);
	
	void delete(String roomId);
}
