package com.caidongmei.alumniassociation.pojo;

import java.io.Serializable;
import java.util.Set;
//ϵԺ
public class ClassDept implements Serializable{
	/**
	 *@author cai 
	 */
	private static final long serialVersionUID = -7101263304710424647L;
private int classdeptid;
private String classdeptname;
private String classdescription;

private String remark;
private Set<ClassOne> classes;//one-many

public ClassDept() {
	super();
	// TODO Auto-generated constructor stub
}

public ClassDept(int classdeptid, String classdeptname,
		String classdescription, String remark, Set<ClassOne> classes) {
	super();
	this.classdeptid = classdeptid;
	this.classdeptname = classdeptname;
	this.classdescription = classdescription;
	this.remark = remark;
	this.classes = classes;
}
public int getClassdeptid() {
	return classdeptid;
}
public void setClassdeptid(int classdeptid) {
	this.classdeptid = classdeptid;
}
public String getClassdeptname() {
	return classdeptname;
}
public void setClassdeptname(String classdeptname) {
	this.classdeptname = classdeptname;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Set<ClassOne> getClasses() {
	return classes;
}
public void setClasses(Set<ClassOne> classes) {
	this.classes = classes;
}

public String getClassdescription() {
	return classdescription;
}
public void setClassdescription(String classdescription) {
	this.classdescription = classdescription;
}
}
