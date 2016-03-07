package org.springframework.social.gitter.api;

public class User {
	
	private String id;
	
	private String username;
	
	private String displayName;
	
	private String url;
	
	private String avatarUrlSmall;
	
	private String avatarUrlMedium;

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getAvatarUrlSmall() {
		return avatarUrlSmall;
	}
	
	public void setAvatarUrlSmall(String avatarUrlSmall) {
		this.avatarUrlSmall = avatarUrlSmall;
	}
	
	public String getAvatarUrlMedium() {
		return avatarUrlMedium;
	}
	
	public void setAvatarUrlMedium(String avatarUrlMedium) {
		this.avatarUrlMedium = avatarUrlMedium;
	}
	
}
