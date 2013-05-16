package com.caidongmei.alumniassociation.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.caidongmei.alumniassociation.pojo.ClassDept;
import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.service.UserService;
import com.caidongmei.alumniassociation.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
//�û���Ϣ����
public class UserAction extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();
	/**
	 * @author CaiDongmei
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private String username;
	private String gender;
	private String classdept;
	private String classone;
	private String password;
	private String identitycard;
	private String answerquestion;
	private String replyquestion;
	private String email;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private int userid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClassdept() {
		return classdept;
	}

	public void setClassdept(String classdept) {
		this.classdept = classdept;
	}

	public String getClassone() {
		return classone;
	}

	public void setClassone(String classone) {
		this.classone = classone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentitycard() {
		return identitycard;
	}

	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	// �������ϵԺ
	public String getAllDept() {
		List<ClassDept> classdeptlist = (List<ClassDept>) userService
				.listAllDept();
		List<ClassOne> classonelist = (List<ClassOne>) userService
				.listAllClass();
		request.setAttribute("classdeptlist", classdeptlist);
		request.setAttribute("classonelist", classonelist);
		return "alldept";
	}

	public String register() {
		// �Ȳ�ѯ�Ƿ��и��û������û���+���֤
		if (userService
				.isExistByUsernameandIdentitycard(username, identitycard)) {
			// �����û���Ϣ
			User user = new User();
			user = userService.isExistByUsernameIdentitycard(username,
					identitycard);
			int userid = user.getUserid();
			User theuser = new User();
			theuser.setAge(user.getAge());
			theuser.setArea(user.getArea());
			theuser.setCellphone(user.getCellphone());
			theuser.setCity(user.getCity());
			theuser.setContactaddress(user.getContactaddress());
			theuser.setGraduation(user.getGraduation());
			theuser.setMajor(user.getMajor());
			theuser.setState(user.getState());
			theuser.setXuehao(user.getXuehao());
			theuser.setUsername(username);
			theuser.setUserid(userid);
			theuser.setAnswerquestion(answerquestion);
			theuser.setEmail(email);
			theuser.setGender(gender);
			theuser.setReplyquestion(replyquestion);
			theuser.setPassword(password);
			theuser.setIdentitycard(identitycard);
			// �����state=2,�����
			theuser.setState(2);
			// ����classname���classid
			theuser.setClassone(userService.getClassOneByName(classone));
			//Ĭ��Ϊѧ��roleid=3		
			theuser.setRole(userService.getRole(3));			
			userService.updateUser(theuser);
			return "register";
		} else
			return "error";
	}

	// �û���¼
	public String login() throws Exception {
		if (userService.isExistByAccountPassword(username, password)) {
			HttpSession session = request.getSession();
			// session.setAttribute("userid", userByName.getUserid());
			session.setAttribute("username", username);

			if (userService.isExistByAccountandPassword(username, password)
					.getRole().getRoleid() == 0) {
				return "admin";
			}
			// state=1��ʾ���ͨ��
			else if (userService
					.isExistByAccountandPassword(username, password).getState() == 1) {
				session.setAttribute("entertime", userService
						.isExistByAccountandPassword(username, password)
						.getGraduation());
				session.setAttribute("classname", userService
						.isExistByAccountandPassword(username, password)
						.getClassone().getClassname());
				List<ClassDept> deptlist = new ArrayList<ClassDept>();
				deptlist.add(userService
						.isExistByAccountandPassword(username, password)
						.getClassone().getClassdept());
				
				session.setAttribute("deptlist", deptlist);
				session.setAttribute("classdeptname", userService
						.isExistByAccountandPassword(username, password)
						.getClassone().getClassdept().getClassdeptname());
				session.setAttribute("user", userService
						.isExistByAccountandPassword(username, password));
				session.setAttribute("classname", userService
						.isExistByAccountandPassword(username, password)
						.getClassone().getClassname());
				session.setAttribute("remark", userService
						.isExistByAccountandPassword(username, password)
						.getRemark());
				return "login";
			} else {
				return "unpromise";
			}
		}

		else
			return "error";

	}

	// ����Աע����ˣ�����ʾ����ѧ��
	public String showUsers() throws Exception {
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = userService.getcurrPage(page);
		String sql = "from User";
		// ��ȡ��ҳ���
		PageModel pageModel = userService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);

		List<ClassDept> classdeptlist = (List<ClassDept>) userService
				.listAllDept();
		List<ClassOne> classonelist = (List<ClassOne>) userService
				.listAllClass();
		request.setAttribute("classdeptlist", classdeptlist);
		request.setAttribute("classonelist", classonelist);
		// ��̨�����û�
		return "showusers";
	}

	// ����id��ö���
	public String searchOneById() throws Exception {
		List<User> userone = new ArrayList<User>();
		userone.add(userService.getUser(userid));
		request.setAttribute("userslist", userone);
		return "detailuser";

	}

	// ��̨����Ա�����ͨ��
	public String promise() throws Exception {
		User user = userService.getUser(userid);
		System.out.println(user.getClassone().getClassname());
		user.setUserid(userid);
		user.setState(1);//1���ͨ����2����� ��0δע�� 
		//����ڰ༶������Ϊ1�������ø�ͬѧ��roleidΪ2����Ϊ�༶����Ա
		if(userService.isZeroPeople(user.getClassone().getClassname(),user.getClassone().getEntertime())==true){
			user.setRole(userService.getRole(2));
			//Ĭ�ϼ���༶
			user.setIsjoinclass(1);
			//ʹclassone��������1
			ClassOne classone=user.getClassone();
			classone.setClassid(user.getClassone().getClassid());
			classone.setPeoplecount(user.getClassone().getPeoplecount()+1);
			userService.updateClassOne(classone);
			//userService.updateUser(user);
			
		}
		userService.updateUser(user);
		return "promise";
	}

	// ��̨����Ա��ȡ��ͨ��
	public String unpromise() throws Exception {
		User user = userService.getUser(userid);
		user.setUserid(userid);
		user.setState(0);
		//ʹ��Ӧ�İ༶������1
		userService.updateUser(user);
		return "promise";
	}

	// ��̨����Ա��ɾ���û�
	public String deleteUser() throws Exception {
		userService.delete(userid);
		return "promise";
	}

	// �û��Լ����޸��û���Ϣ-----������������
	public String updateUser() throws Exception {
		User user = userService.getUser(userid);
		return "promise";
	}

	// ��������ѯ�û�
	// ��������ѯ����
	public String searchUsers() throws Exception {
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = userService.getcurrPage(page);
		String sql = userService.getSql(username, identitycard, classdept,
				classone, state);
		// ��ȡ��ҳ���
		PageModel pageModel = userService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);
		return "showusers";

	}
}
