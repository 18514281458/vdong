package com.vdong.restful.response;

public class Message {

	private String type;
	private String messageDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public static Message putMessage(String type, String messageDate) {

		Message message = new Message();
		message.setType(type);
		message.setMessageDate(messageDate);
		return message;
	}
}
