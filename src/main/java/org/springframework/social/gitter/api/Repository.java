package org.springframework.social.gitter.api;

public class Repository {
		
	private String id;
	
	private String name;
	
	private String uri;
	
	private Room rooms;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public Room getRooms() {
		return rooms;
	}
	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}
	
}
