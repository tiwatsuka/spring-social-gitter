package org.springframework.social.gitter.api;

import java.util.List;

public class UnreadItems {

	private List<String> chat;
	
	private List<String> mention;
	
	public List<String> getChat() {
		return chat;
	}
	public void setChat(List<String> chat) {
		this.chat = chat;
	}
	
	public List<String> getMention() {
		return mention;
	}
	public void setMention(List<String> mention) {
		this.mention = mention;
	}
}
