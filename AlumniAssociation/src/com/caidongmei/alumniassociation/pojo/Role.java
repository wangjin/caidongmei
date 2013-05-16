package com.caidongmei.alumniassociation.pojo;
//½ÇÉ«
public class Role {
private int roleid;
private String rolename;
private String remark;
//private Set<User> users;//many-one
public Role() {
	super();
	// TODO Auto-generated constructor stub
}
public Role(int roleid, String rolename, String remark) {
	super();
	this.roleid = roleid;
	this.rolename = rolename;
	this.remark = remark;
	
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

}
