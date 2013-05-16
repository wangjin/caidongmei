package com.caidongmei.alumniassociation.pojo;
import java.util.Set;
//班级
public class ClassOne {
private int classid;//主键
private int iscreate;//是否被创建
private String entertime; //入学年份
private String createtime;  //创建日期
private int peoplecount;//班级人数
private String classname;
private String description;
private String remark;
private ClassDept classdept;//one-one
private Set<User>users;

public ClassOne() {
	super();
	// TODO Auto-generated constructor stub
}

public ClassOne(int iscreate, String entertime, String createtime,
		int peoplecount, String classname, String description, String remark,
		ClassDept classdept, Set<User> users) {
	super();
	this.iscreate = iscreate;
	this.entertime = entertime;
	this.createtime = createtime;
	this.peoplecount = peoplecount;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
}

/*public ClassOne(int classid, String classname, String description, String remark,
		ClassDept classdept, Set<User> users) {
	super();
	this.classid = classid;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
}

public ClassOne(int iscreate, String entertime, String classname,
		String description, String remark) {
	super();
	this.iscreate = iscreate;
	this.entertime = entertime;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
}
public ClassOne(String classname, String description, String remark,
		ClassDept classdept, Set<User> users, int iscreate) {
	super();
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
	this.iscreate = iscreate;
}

public ClassOne(int classid, int iscreate, String entertime, String classname,
		String description, String remark, ClassDept classdept, Set<User> users) {
	super();
	this.classid = classid;
	this.iscreate = iscreate;
	this.entertime = entertime;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
}

public ClassOne(int iscreate, String entertime, String classname,
		String description, String remark, ClassDept classdept, Set<User> users) {
	super();
	this.iscreate = iscreate;
	this.entertime = entertime;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
}*/

public ClassOne(int classid, int iscreate, String entertime, String createtime,
		int peoplecount, String classname, String description, String remark,
		ClassDept classdept, Set<User> users) {
	super();
	this.classid = classid;
	this.iscreate = iscreate;
	this.entertime = entertime;
	this.createtime = createtime;
	this.peoplecount = peoplecount;
	this.classname = classname;
	this.description = description;
	this.remark = remark;
	this.classdept = classdept;
	this.users = users;
}

public String getCreatetime() {
	return createtime;
}
public void setCreatetime(String createtime) {
	this.createtime = createtime;
}
public int getPeoplecount() {
	return peoplecount;
}
public void setPeoplecount(int peoplecount) {
	this.peoplecount = peoplecount;
}
public String getEntertime() {
	return entertime;
}
public void setEntertime(String entertime) {
	this.entertime = entertime;
}
public int getIscreate() {
	return iscreate;
}
public void setIscreate(int iscreate) {
	this.iscreate = iscreate;
}
public int getClassid() {
	return classid;
}
public void setClassid(int classid) {
	this.classid = classid;
}
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public ClassDept getClassdept() {
	return classdept;
}
public void setClassdept(ClassDept classdept) {
	this.classdept = classdept;
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}

}
