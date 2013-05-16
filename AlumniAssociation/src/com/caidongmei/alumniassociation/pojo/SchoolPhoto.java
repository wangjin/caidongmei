package com.caidongmei.alumniassociation.pojo;
//–£‘∞œ‡≤·
public class SchoolPhoto {
private int photoid;
private String name;
private String pubtime;
public String getPubtime() {
	return pubtime;
}

public void setPubtime(String pubtime) {
	this.pubtime = pubtime;
}

private String url;

public SchoolPhoto() {
	super();
	// TODO Auto-generated constructor stub
}
public SchoolPhoto(String name, String pubtime, String url) {
	super();
	this.name = name;
	this.pubtime = pubtime;
	this.url = url;
}

public SchoolPhoto(int photoid, String name, String pubtime, String url) {
	super();
	this.photoid = photoid;
	this.name = name;
	this.pubtime = pubtime;
	this.url = url;
}

public int getPhotoid() {
	return photoid;
}

public void setPhotoid(int photoid) {
	this.photoid = photoid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

}
