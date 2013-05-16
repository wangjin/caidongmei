package com.caidongmei.alumniassociation.pojo;
//Ð£Ô°ÐÂÎÅ
public class News {
private int newsid;
private String newstitle;
private String newscontent;
private String pubtime;
private int browsevolume;
private String url;
public News() {
	super();
	// TODO Auto-generated constructor stub
}


public News(int newsid, String newstitle, String newscontent, String pubtime,
		int browsevolume, String url) {
	super();
	this.newsid = newsid;
	this.newstitle = newstitle;
	this.newscontent = newscontent;
	this.pubtime = pubtime;
	this.browsevolume = browsevolume;
	this.url = url;
}


public News(String newstitle, String newscontent, String pubtime,
		int browsevolume, String url) {
	super();
	this.newstitle = newstitle;
	this.newscontent = newscontent;
	this.pubtime = pubtime;
	this.browsevolume = browsevolume;
	this.url = url;
}


public int getNewsid() {
	return newsid;
}
public void setNewsid(int newsid) {
	this.newsid = newsid;
}
public String getNewstitle() {
	return newstitle;
}
public void setNewstitle(String newstitle) {
	this.newstitle = newstitle;
}
public String getNewscontent() {
	return newscontent;
}
public void setNewscontent(String newscontent) {
	this.newscontent = newscontent;
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
public int getBrowsevolume() {
	return browsevolume;
}
public void setBrowsevolume(int browsevolume) {
	this.browsevolume = browsevolume;
}


}
