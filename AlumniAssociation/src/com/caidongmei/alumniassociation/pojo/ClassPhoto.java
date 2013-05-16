package com.caidongmei.alumniassociation.pojo;

import java.io.Serializable;

//班级相册
public class ClassPhoto implements Serializable {
	/**
	 * @author cai
	 */
	private static final long serialVersionUID = 5430826692451158696L;
	private int id;
	private String name;
	private String pubtime;
	private String username;// 上传者;
	private Photokind photokind;
	private int iscover;
	private String url;

	public ClassPhoto() {
		super();
	}

	public ClassPhoto(String name, String pubtime, String username,
			Photokind photokind, int iscover, String url) {
		super();
		this.name = name;
		this.pubtime = pubtime;
		this.username = username;
		this.photokind = photokind;
		this.iscover = iscover;
		this.url = url;
	}

	public ClassPhoto(int id, String name, String pubtime, String username,
			Photokind photokind, int iscover, String url) {
		super();
		this.id = id;
		this.name = name;
		this.pubtime = pubtime;
		this.username = username;
		this.photokind = photokind;
		this.iscover = iscover;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Photokind getPhotokind() {
		return photokind;
	}

	public void setPhotokind(Photokind photokind) {
		this.photokind = photokind;
	}

	public int getIscover() {
		return iscover;
	}

	public void setIscover(int iscover) {
		this.iscover = iscover;
	}

}
