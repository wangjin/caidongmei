package com.caidongmei.alumniassociation.pojo;
//¹«¸æ
public class Notice {
private int noticeid;
private String title;
private String content;
private String url;
private String pubtime;
public Notice() {
	super();
	// TODO Auto-generated constructor stub
}
public Notice(int noticeid, String title, String content, String url,
		String pubtime) {
	super();
	this.noticeid = noticeid;
	this.title = title;
	this.content = content;
	this.url = url;
	this.pubtime = pubtime;
}
public Notice(String title, String content, String url, String pubtime) {
	super();
	this.title = title;
	this.content = content;
	this.url = url;
	this.pubtime = pubtime;
}
public int getNoticeid() {
	return noticeid;
}
public void setNoticeid(int noticeid) {
	this.noticeid = noticeid;
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getPubtime() {
	return pubtime;
}
public void setPubtime(String pubtime) {
	this.pubtime = pubtime;
}
}
