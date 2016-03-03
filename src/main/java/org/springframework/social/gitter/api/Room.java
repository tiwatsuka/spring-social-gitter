package org.springframework.social.gitter.api;


import java.time.ZonedDateTime;
import java.util.List;

public class Room {
	private String id;
	
	private String name;
	
	private String topic;
	
	private String uri;
	
	private boolean oneToOne;
	
	private List<User> users;
	
	private int userCount;
	
	private int unreadItems;
	
	private int mentions;
	
	private ZonedDateTime lastAccessTime;
	
	private boolean favourite;
	
	private boolean lurk;
	
	private String url;
	
	private RoomType githubType;
	
	private List<String> tags;
	
	private int v;
	
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
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public boolean isOneToOne() {
		return oneToOne;
	}
	
	public void setOneToOne(boolean oneToOne) {
		this.oneToOne = oneToOne;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public int getUserCount() {
		return userCount;
	}
	
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
	public int getUnreadItems() {
		return unreadItems;
	}
	
	public void setUnreadItems(int unreadItems) {
		this.unreadItems = unreadItems;
	}
	
	public int getMentions() {
		return mentions;
	}
	
	public void setMentions(int mentions) {
		this.mentions = mentions;
	}
	
	public ZonedDateTime getLastAccessTime() {
		return lastAccessTime;
	}
	
	public void setLastAccessTime(ZonedDateTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
	public boolean isFavourite() {
		return favourite;
	}
	
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
	
	public boolean isLurk() {
		return lurk;
	}
	
	public void setLurk(boolean lurk) {
		this.lurk = lurk;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public RoomType getGithubType() {
		return githubType;
	}
	
	public void setGithubType(RoomType githubType) {
		this.githubType = githubType;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public int getV() {
		return v;
	}
	
	public void setV(int v) {
		this.v = v;
	}
}

