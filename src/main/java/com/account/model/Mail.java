package com.account.model;

public class Mail {
	/**
	 * 邮件发送者
	 */
	private String from = "joecqupt@126.com";
	/**
	 * 邮件接收者
	 */
	private String to;
	/**
	 * 邮件主题
	 */
	private String subject;
	/**
	 * 邮件 内容
	 */
	private String contentText;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}
	/**
	 * 邮件接收者
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}
	/**
	 * 邮件主题
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContentText() {
		return contentText;
	}
	/**
	 * 邮件的内容
	 * @param contentText
	 */
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

}
