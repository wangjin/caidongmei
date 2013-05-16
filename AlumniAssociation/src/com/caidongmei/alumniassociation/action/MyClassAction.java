package com.caidongmei.alumniassociation.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.ClassPhoto;
import com.caidongmei.alumniassociation.pojo.Message;
import com.caidongmei.alumniassociation.pojo.Photokind;
import com.caidongmei.alumniassociation.pojo.Role;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.service.MyClassService;
import com.caidongmei.alumniassociation.service.UserService;
import com.caidongmei.alumniassociation.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class MyClassAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MyClassService myclassService;
	@Autowired
	private UserService userService;
	private String classname;
	private String classdeptname;
	private String entertime;
	private int kindid;
	// 相册名字
	private String name;
	// 相册描述
	private String description;
	private String selectphoto;
	private String searchtype;
	private String keyword;
	//留言内容
    private String messagecontent;
    //留言的图片
    private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public String getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSelectphoto() {
		return selectphoto;
	}

	public void setSelectphoto(String selectphoto) {
		this.selectphoto = selectphoto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKindid() {
		return kindid;
	}

	public void setKindid(int kindid) {
		this.kindid = kindid;
	}

	HttpServletRequest request = ServletActionContext.getRequest();

	private List<ClassPhoto> lvlPhotolist;

	public List<ClassPhoto> getLvlPhotolist() {
		return lvlPhotolist;
	}

	public void setLvlPhotolist(List<ClassPhoto> lvlPhotolist) {
		this.lvlPhotolist = lvlPhotolist;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassdeptname() {
		return classdeptname;
	}

	public void setClassdeptname(String classdeptname) {
		this.classdeptname = classdeptname;
	}

	public String getEntertime() {
		return entertime;
	}

	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}

	User user = (User) request.getSession().getAttribute("user");
	int classid = ((User) request.getSession().getAttribute("user"))
			.getClassone().getClassid();
	HttpSession session = request.getSession();

	public String showClass() {

		Map<Integer, Integer> mapclasses = new HashMap<Integer, Integer>();
		mapclasses = myclassService.getClasses();
		request.setAttribute("mapclasses", mapclasses);
		List<Integer> sortedKeys = new ArrayList<Integer>(mapclasses.keySet());
		Collections.sort(sortedKeys);
		request.setAttribute("sortedKeys", sortedKeys);
		// 1.计算班级总数，
		request.setAttribute("classcount", myclassService.getClassCount());
		// 2.已加入校友
		request.setAttribute("peoplecount",
				myclassService.getHaveEnterStudent());
		// 3.
		getTopNine();
		return "showclass";
	}

	public String createClass() {
		// 首先判定入学年份+班级存在不，不存在，创建成功，存在，不能创建
		if (myclassService.isCreate(entertime, classname)) {
			// 该用户角色的id改成2，表示班级管理员
			Role role = new Role();
			role.setRoleid(2);
			role.setRolename("班级管理员");
			role.setRemark("班级管理员");
			user.setRole(role);
			// 表示已经加入班级
			user.setIsjoinclass(1);
			// 把创建字段设为1已经创建
			user.getClassone().setIscreate(1);
			user.getClassone().setPeoplecount(
					user.getClassone().getPeoplecount() + 1);
			// 创建时间
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createtime = df.format(date);
			user.getClassone().setCreatetime(createtime);
			userService.saveOrUpdate(user);

			return "createclass";
		} else
			return "applyforenterclass";// 未写好，显示 ，班级已经创建，不能再创建，只能申请加入
	}

	public String showLevelClass() {
		// 该届的所有班级
		request.setAttribute("levelclasslsit",
				myclassService.listLevelClasses(entertime));

		String page = request.getParameter("currPage");
		// 每页显示6条记录
		int pageSize = 6;
		int currPage = myclassService.getcurrPage(page);
		String sql = "from ClassOne where entertime='" + entertime
				+ "' and iscreate=1";
		// 获取分页组件
		PageModel pageModel = myclassService.findPaging(sql, currPage,
				pageSize, sql);
		request.setAttribute("pageModel", pageModel);
		getTopNine();
		return "showlevelclass";
	}

	// 申请加入班级
	public String applyforenterClass() {

		user.setIsjoinclass(1);
		user.getClassone().setPeoplecount(
				user.getClassone().getPeoplecount() + 1);
		userService.saveOrUpdate(user);
		return "haveapplyforenterclass";
	}

	public void getTopNine() {
		// 3.根据班级人数，显示前9个班级
		List<ClassOne> classlistnine = myclassService.listTopNine("ClassOne");
		request.setAttribute("classlistnine", classlistnine);
	}

	// 进入班级首页
	public String showHomepage() {
		if (user.getIsjoinclass() == 1
				&& user.getGraduation().equals(entertime)
				&& user.getClassone().getClassname().equals(classname)) {
			return "homepage";
		} else
			return "errorhomepage";
	}

	// 更新头像
	public String updatePhoto() {
		userService.saveOrUpdate(user);
		return "updatephoto";
	}

	// 显示通讯录
	public String addressBook() {
		String page = request.getParameter("currPage");
		// 每页显示6条记录
		int pageSize = 6;
		int currPage = userService.getcurrPage(page);
		classname = (String) request.getSession().getAttribute("classname");
		String sql = "from User where isjoinclass=1 and classone.classname='"
				+ classname + "'";
		// 获取分页组件
		PageModel pageModel = userService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);

		return "addressbook";

	}

	// 班级相册
	public String showClassphoto() {

		List<ClassPhoto> photolist = myclassService.getClassPhotolist(classid);
		List<Photokind> photokindlist = myclassService
				.getClassPhotolistNON(classid);
		// 封面照片的集合
		request.setAttribute("photolist", photolist);
		// 没有封面的相册
		request.setAttribute("photokindlist", photokindlist);
		// 所有相册,根据班级
		request.setAttribute("pklist", myclassService.getAllPhotokind(user.getClassone().getClassid()));
		if (("selectphoto").equals(selectphoto)) {
			return "selectphoto";
		} else if (("2").equals(selectphoto)) {
			return "selectphotoclass";
		} else
			return "showclassphoto";
	}

	// 根据kindid相册，显示该相册里所有照片
	public String getLevelPhotolist() {
		lvlPhotolist = myclassService.getLevelPhotolist(kindid);
		session.setAttribute("albumname", lvlPhotolist.get(0).getPhotokind()
				.getKindname());
		return "levelphotolist";
	}

	// 创建相册
	public String createAlbum() {
		Photokind pk = new Photokind(name, classid, description);
		session.setAttribute("albumname", name);
		myclassService.createAlbum(pk);
		return "createalbum";
	}

	public String backSearchPhone() {
		return "searchphone";
	}

	// 按专业或者同学，入学年份查询班级

	public String searchBy() {
		String specialty = "specialty";
		// 系院+年份
		if (searchtype.equals(specialty)) {
			if (entertime.length() < 1 && keyword.length() < 1) {
				request.setAttribute("classlist", myclassService.listClass());
				return "searchby";
			} else {
				List<ClassOne> classdeptlist = myclassService.listClasses(
						entertime, keyword);
				if (classdeptlist.size() > 0) {
					request.setAttribute("classlist", classdeptlist);
					return "searchby";
				} else
					return "nonesearchby";
			}

		}
		// 同学+年份
		else {
			// 年份为空，姓名为空
			if (entertime.length() < 1 && keyword.length() < 1) {
				request.setAttribute("classlist", myclassService.listClass());
				return "searchby";
			} else {
				// 年份不为空，姓名为空
				if (entertime.length() > 1 && keyword.length() < 1) {
					request.setAttribute("classlist",
							myclassService.listClasses(entertime, null));
					return "searchby";
				} else {
					List<User> userlist = userService
							.getUserlistByName(keyword);
					System.out.println(userlist.size());// 2
					List<ClassOne> classlist = new ArrayList<ClassOne>();
					for (User userone : userlist) {
						// 获得同学的系院
						String classname = userone.getClassone().getClassname();
						System.out.println(entertime);// 商学院
						classlist.add(myclassService.listClasses1(
								userone.getGraduation(), classname));
					}
					if (classlist.size() > 0) {
						request.setAttribute("classlist", classlist);
						return "searchby";
					} else
						return "nonesearchby";
				}
			}
		}
	}
	//显示班级留言班级留言
	public String showMessage(){
		String page = request.getParameter("currPage");
		// 每页显示6条记录
		int pageSize = 6;
		int currPage = myclassService.getcurrPage(page);
		String sql = "from Message where user.classone.classid='" + classid
				+ "' and hostid=0  order by pubtime desc";
		// 获取分页组件
		PageModel pageModel = myclassService.findPaging(sql, currPage,
				pageSize, sql);
		List<Message> messagelist=myclassService.getAllMessages(classid);
		request.setAttribute("pageModel", pageModel);
		request.setAttribute("messagelist", messagelist);
		return "showmessage";
	}
	//添加留言
	public String addMessage(){
		System.out.println(messagecontent);
		System.out.println(code);
		// 取系统当前时间
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pubtime = df.format(date);
        Message message=new Message(messagecontent,pubtime,user,code,0);
        myclassService.saveOrUpdate(message);
		return "addmessage";
		
	}
}
