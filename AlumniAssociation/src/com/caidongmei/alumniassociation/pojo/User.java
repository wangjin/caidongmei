package com.caidongmei.alumniassociation.pojo;

import java.util.Set;

//学生
public class User {
private int userid;
private String username;
private String password;
private String gender;
private String major;
private String cellphone;
private String contactaddress;
private String email;
private String province;
private String city;
private String xuehao;
private String graduation;
private String identitycard;
private int age;
private int state;
private String remark;
private String answerquestion;
private String replyquestion;
private ClassOne classone;//many-one
private Role role;//many-one
private int isjoinclass;
private Set<Message> messages  ;              //one-manny??????没有写
public User(String username, String password, String gender, String major,
		String cellphone, String contactaddress, String email, String province,
		String city, String xuehao, String graduation, String identitycard,
		int age, int state, String remark, String answerquestion,
		String replyquestion, ClassOne classone, Role role, int isjoinclass,
		Set<Message> messages) {
	super();
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.major = major;
	this.cellphone = cellphone;
	this.contactaddress = contactaddress;
	this.email = email;
	this.province = province;
	this.city = city;
	this.xuehao = xuehao;
	this.graduation = graduation;
	this.identitycard = identitycard;
	this.age = age;
	this.state = state;
	this.remark = remark;
	this.answerquestion = answerquestion;
	this.replyquestion = replyquestion;
	this.classone = classone;
	this.role = role;
	this.isjoinclass = isjoinclass;
	this.messages = messages;
}
public Set<Message> getMessages() {
	return messages;
}
public void setMessages(Set<Message> messages) {
	this.messages = messages;
}
public User(String username, String password, String gender, String major,
		String cellphone, String contactaddress, String email, String province,
		String city, String xuehao, String graduation, String identitycard,
		int age, int state, String remark, String answerquestion,
		String replyquestion, ClassOne classone, Role role, int isjoinclass) {
	super();
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.major = major;
	this.cellphone = cellphone;
	this.contactaddress = contactaddress;
	this.email = email;
	this.province = province;
	this.city = city;
	this.xuehao = xuehao;
	this.graduation = graduation;
	this.identitycard = identitycard;
	this.age = age;
	this.state = state;
	this.remark = remark;
	this.answerquestion = answerquestion;
	this.replyquestion = replyquestion;
	this.classone = classone;
	this.role = role;
	this.isjoinclass = isjoinclass;
}
public User(int userid, String username, String password, String gender,
		String major, String cellphone, String contactaddress, String email,
		String province, String city, String xuehao, String graduation,
		String identitycard, int age, int state, String remark,
		String answerquestion, String replyquestion, ClassOne classone,
		Role role, int isjoinclass) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.major = major;
	this.cellphone = cellphone;
	this.contactaddress = contactaddress;
	this.email = email;
	this.province = province;
	this.city = city;
	this.xuehao = xuehao;
	this.graduation = graduation;
	this.identitycard = identitycard;
	this.age = age;
	this.state = state;
	this.remark = remark;
	this.answerquestion = answerquestion;
	this.replyquestion = replyquestion;
	this.classone = classone;
	this.role = role;
	this.isjoinclass = isjoinclass;
}
public User(int userid, String username, String password, String gender,
		String major, String cellphone, String contactaddress, String email,
		String province, String city, String xuehao, String graduation,
		String identitycard, int age, int state, String remark,
		String answerquestion, String replyquestion, ClassOne classone,
		Role role) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.major = major;
	this.cellphone = cellphone;
	this.contactaddress = contactaddress;
	this.email = email;
	this.province = province;
	this.city = city;
	this.xuehao = xuehao;
	this.graduation = graduation;
	this.identitycard = identitycard;
	this.age = age;
	this.state = state;
	this.remark = remark;
	this.answerquestion = answerquestion;
	this.replyquestion = replyquestion;
	this.classone = classone;
	this.role = role;
}
public String getAnswerquestion() {
	return answerquestion;
}
public void setAnswerquestion(String answerquestion) {
	this.answerquestion = answerquestion;
}
public String getReplyquestion() {
	return replyquestion;
}
public void setReplyquestion(String replyquestion) {
	this.replyquestion = replyquestion;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int userid, String username, String password, String gender,
		String major, String cellphone, String contactaddress, String email,
		String province, String city, String xuehao, String graduation,
		String identitycard, int age, int state, String remark,
		ClassOne classone, Role role) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.major = major;
	this.cellphone = cellphone;
	this.contactaddress = contactaddress;
	this.email = email;
	this.province = province;
	this.city = city;
	this.xuehao = xuehao;
	this.graduation = graduation;
	this.identitycard = identitycard;
	this.age = age;
	this.state = state;
	this.remark = remark;
	this.classone = classone;
	this.role = role;
}



public int getIsjoinclass() {
	return isjoinclass;
}
public void setIsjoinclass(int isjoinclass) {
	this.isjoinclass = isjoinclass;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getCellphone() {
	return cellphone;
}
public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
}
public String getContactaddress() {
	return contactaddress;
}
public void setContactaddress(String contactaddress) {
	this.contactaddress = contactaddress;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return xuehao;
}
public void setArea(String area) {
	this.xuehao = area;
}
public String getGraduation() {
	return graduation;
}
public void setGraduation(String graduation) {
	this.graduation = graduation;
}
public String getIdentitycard() {
	return identitycard;
}
public void setIdentitycard(String identitycard) {
	this.identitycard = identitycard;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public ClassOne getClassone() {
	return classone;
}
public String getXuehao() {
	return xuehao;
}
public void setXuehao(String xuehao) {
	this.xuehao = xuehao;
}
public void setClassone(ClassOne classone) {
	this.classone = classone;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}


}
