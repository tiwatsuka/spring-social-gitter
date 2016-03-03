package org.springframework.social.gitter.api;

import java.time.ZonedDateTime;
import java.util.List;

public class Message {
	private String id;
	private String text;
	private String html;
	private ZonedDateTime sent;
	private ZonedDateTime editedAt;
	private User fromUser;
	private boolean unread;
	private int readBy;
	private List<URL> urls;
	private List<Mention> mentions;
	private List<Issue> issues;
	private String v;
	private String gv;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	public ZonedDateTime getSent() {
		return sent;
	}
	public void setSent(ZonedDateTime sent) {
		this.sent = sent;
	}
	
	public ZonedDateTime getEditedAt() {
		return editedAt;
	}
	public void setEditedAt(ZonedDateTime editedAt) {
		this.editedAt = editedAt;
	}
	
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	
	public boolean isUnread() {
		return unread;
	}
	public void setUnread(boolean unread) {
		this.unread = unread;
	}
	
	public int getReadBy() {
		return readBy;
	}
	public void setReadBy(int readBy) {
		this.readBy = readBy;
	}
	
	public List<URL> getUrls() {
		return urls;
	}
	public void setUrls(List<URL> urls) {
		this.urls = urls;
	}
	
	public List<Mention> getMentions() {
		return mentions;
	}
	public void setMentions(List<Mention> mentions) {
		this.mentions = mentions;
	}
	
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
	public String getGv() {
		return gv;
	}
	public void setGv(String gv) {
		this.gv = gv;
	}
	
	public class Mention {
		private String screenName;
		
		private String userId;
		
		public String getScreenName() {
			return screenName;
		}
		
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		
		public String getUserId() {
			return userId;
		}
		
		public void setUserId(String userId) {
			this.userId = userId;
		}
	}
	
	public class Issue {
		String number;
		
		public String getNumber() {
			return number;
		}
		
		public void setNumber(String number) {
			this.number = number;
		}
	}

	public class URL{
		private String url;
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
	
}
