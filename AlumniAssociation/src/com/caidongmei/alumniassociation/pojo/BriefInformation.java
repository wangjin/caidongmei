package com.caidongmei.alumniassociation.pojo;
//Ð£Ô°¼ò½é
public class BriefInformation {
private int briefid;
private String title;
private String content;
private String pubtime;
private String url;
public BriefInformation() {
	super();
	// TODO Auto-generated constructor stub
}
public BriefInformation(int briefid, String title, String content,
		String pubtime, String url) {
	super();
	this.briefid = briefid;
	this.title = title;
	this.content = content;
	this.pubtime = pubtime;
	this.url = url;
	
}

public BriefInformation(String title, String content, String pubtime, String url) {
	super();
	this.title = title;
	this.content = content;
	this.pubtime = pubtime;
	this.url = url;
}
public int getBriefid() {
	return briefid;
}
public void setBriefid(int briefid) {
	this.briefid = briefid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
}
