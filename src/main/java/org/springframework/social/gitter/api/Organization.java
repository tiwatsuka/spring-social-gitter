package org.springframework.social.gitter.api;

public class Organization {

	private String id;
	
	private String name;
	
	private String avaterUrl;
	
	private Room room;
	
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
	
	public String getAvaterUrl() {
		return avaterUrl;
	}
	public void setAvaterUrl(String avaterUrl) {
		this.avaterUrl = avaterUrl;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
}
