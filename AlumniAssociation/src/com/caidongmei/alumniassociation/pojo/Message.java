package com.caidongmei.alumniassociation.pojo;
//Ö÷ÁôÑÔ
public class Message {
private int messageid;
private String content;//ÁôÑÔÄÚÈİ
private String pubtime;//ÁôÑÔÊ±¼ä
private User user;
private String code;
private int hostid;//one-to-many 
public Message() {
	super();
	// TODO Auto-generated constructor stub
}

public Message(String content, String pubtime, User user, String code,
		int hostid) {
	super();
	this.content = content;
	this.pubtime = pubtime;
	this.user = user;
	this.code = code;
	this.hostid = hostid;
}

public Message(int messageid, String content, String pubtime, User user,
		String code, int hostid) {
	super();
	this.messageid = messageid;
	this.content = content;
	this.pubtime = pubtime;
	this.user = user;
	this.code = code;
	this.hostid = hostid;
}



public String getCode() {
	return code;
}



public void setCode(String code) {
	this.code = code;
}



public int getMessageid() {
	return messageid;
}
public void setMessageid(int messageid) {
	this.messageid = messageid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPubtime() {
	return pubtime;
}
public void setPubtime(String pubtime) {
	this.pubtime = pubtime;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getHostid() {
	return hostid;
}
public void setHostid(int hostid) {
	this.hostid = hostid;
}

}