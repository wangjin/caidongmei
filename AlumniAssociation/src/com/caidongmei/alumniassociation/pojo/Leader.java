package com.caidongmei.alumniassociation.pojo;

public class Leader {
private int leaderid;
private String name;
private String introduction;
private String url;
private String dept;
private String content;
public Leader() {
	super();
	// TODO Auto-generated constructor stub
}
public Leader(int leaderid, String name, String introduction, String url,
		String dept, String content) {
	super();
	this.leaderid = leaderid;
	this.name = name;
	this.introduction = introduction;
	this.url = url;
	this.dept = dept;
	this.content = content;
}
public Leader(String name, String introduction, String url, String dept,
		String content) {
	super();
	this.name = name;
	this.introduction = introduction;
	this.url = url;
	this.dept = dept;
	this.content = content;
}
public int getLeaderid() {
	return leaderid;
}
public void setLeaderid(int leaderid) {
	this.leaderid = leaderid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
}
