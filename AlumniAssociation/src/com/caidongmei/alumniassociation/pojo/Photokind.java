package com.caidongmei.alumniassociation.pojo;

import java.util.Set;

//½ÇÉ«
public class Photokind {
private int kindid;
private String kindname;
private int classid;
private String description;
private Set<ClassPhoto> classphotos;//many-one
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Photokind() {
	super();
	// TODO Auto-generated constructor stub
}

public Photokind(String kindname, int classid, String description,
		Set<ClassPhoto> classphotos) {
	super();
	this.kindname = kindname;
	this.classid = classid;
	this.description = description;
	this.classphotos = classphotos;
}
public Photokind(String kindname, int classid, String description) {
	super();
	this.kindname = kindname;
	this.classid = classid;
	this.description = description;
}
public Photokind(int kindid, String kindname, int classid, String description,
		Set<ClassPhoto> classphotos) {
	super();
	this.kindid = kindid;
	this.kindname = kindname;
	this.classid = classid;
	this.description = description;
	this.classphotos = classphotos;
}
public int getKindid() {
	return kindid;
}
public void setKindid(int kindid) {
	this.kindid = kindid;
}
public String getKindname() {
	return kindname;
}
public void setKindname(String kindname) {
	this.kindname = kindname;
}
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public Set<ClassPhoto> getClassphotos() {
	return classphotos;
}
public void setClassphotos(Set<ClassPhoto> classphotos) {
	this.classphotos = classphotos;
}


}
