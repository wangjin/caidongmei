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
	// �������
	private String name;
	// �������
	private String description;
	private String selectphoto;
	private String searchtype;
	private String keyword;
	//��������
    private String messagecontent;
    //���Ե�ͼƬ
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
		// 1.����༶������
		request.setAttribute("classcount", myclassService.getClassCount());
		// 2.�Ѽ���У��
		request.setAttribute("peoplecount",
				myclassService.getHaveEnterStudent());
		// 3.
		getTopNine();
		return "showclass";
	}

	public String createClass() {
		// �����ж���ѧ���+�༶���ڲ��������ڣ������ɹ������ڣ����ܴ���
		if (myclassService.isCreate(entertime, classname)) {
			// ���û���ɫ��id�ĳ�2����ʾ�༶����Ա
			Role role = new Role();
			role.setRoleid(2);
			role.setRolename("�༶����Ա");
			role.setRemark("�༶����Ա");
			user.setRole(role);
			// ��ʾ�Ѿ�����༶
			user.setIsjoinclass(1);
			// �Ѵ����ֶ���Ϊ1�Ѿ�����
			user.getClassone().setIscreate(1);
			user.getClassone().setPeoplecount(
					user.getClassone().getPeoplecount() + 1);
			// ����ʱ��
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createtime = df.format(date);
			user.getClassone().setCreatetime(createtime);
			userService.saveOrUpdate(user);

			return "createclass";
		} else
			return "applyforenterclass";// δд�ã���ʾ ���༶�Ѿ������������ٴ�����ֻ���������
	}

	public String showLevelClass() {
		// �ý�����а༶
		request.setAttribute("levelclasslsit",
				myclassService.listLevelClasses(entertime));

		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = myclassService.getcurrPage(page);
		String sql = "from ClassOne where entertime='" + entertime
				+ "' and iscreate=1";
		// ��ȡ��ҳ���
		PageModel pageModel = myclassService.findPaging(sql, currPage,
				pageSize, sql);
		request.setAttribute("pageModel", pageModel);
		getTopNine();
		return "showlevelclass";
	}

	// �������༶
	public String applyforenterClass() {

		user.setIsjoinclass(1);
		user.getClassone().setPeoplecount(
				user.getClassone().getPeoplecount() + 1);
		userService.saveOrUpdate(user);
		return "haveapplyforenterclass";
	}

	public void getTopNine() {
		// 3.���ݰ༶��������ʾǰ9���༶
		List<ClassOne> classlistnine = myclassService.listTopNine("ClassOne");
		request.setAttribute("classlistnine", classlistnine);
	}

	// ����༶��ҳ
	public String showHomepage() {
		if (user.getIsjoinclass() == 1
				&& user.getGraduation().equals(entertime)
				&& user.getClassone().getClassname().equals(classname)) {
			return "homepage";
		} else
			return "errorhomepage";
	}

	// ����ͷ��
	public String updatePhoto() {
		userService.saveOrUpdate(user);
		return "updatephoto";
	}

	// ��ʾͨѶ¼
	public String addressBook() {
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = userService.getcurrPage(page);
		classname = (String) request.getSession().getAttribute("classname");
		String sql = "from User where isjoinclass=1 and classone.classname='"
				+ classname + "'";
		// ��ȡ��ҳ���
		PageModel pageModel = userService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);

		return "addressbook";

	}

	// �༶���
	public String showClassphoto() {

		List<ClassPhoto> photolist = myclassService.getClassPhotolist(classid);
		List<Photokind> photokindlist = myclassService
				.getClassPhotolistNON(classid);
		// ������Ƭ�ļ���
		request.setAttribute("photolist", photolist);
		// û�з�������
		request.setAttribute("photokindlist", photokindlist);
		// �������,���ݰ༶
		request.setAttribute("pklist", myclassService.getAllPhotokind(user.getClassone().getClassid()));
		if (("selectphoto").equals(selectphoto)) {
			return "selectphoto";
		} else if (("2").equals(selectphoto)) {
			return "selectphotoclass";
		} else
			return "showclassphoto";
	}

	// ����kindid��ᣬ��ʾ�������������Ƭ
	public String getLevelPhotolist() {
		lvlPhotolist = myclassService.getLevelPhotolist(kindid);
		session.setAttribute("albumname", lvlPhotolist.get(0).getPhotokind()
				.getKindname());
		return "levelphotolist";
	}

	// �������
	public String createAlbum() {
		Photokind pk = new Photokind(name, classid, description);
		session.setAttribute("albumname", name);
		myclassService.createAlbum(pk);
		return "createalbum";
	}

	public String backSearchPhone() {
		return "searchphone";
	}

	// ��רҵ����ͬѧ����ѧ��ݲ�ѯ�༶

	public String searchBy() {
		String specialty = "specialty";
		// ϵԺ+���
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
		// ͬѧ+���
		else {
			// ���Ϊ�գ�����Ϊ��
			if (entertime.length() < 1 && keyword.length() < 1) {
				request.setAttribute("classlist", myclassService.listClass());
				return "searchby";
			} else {
				// ��ݲ�Ϊ�գ�����Ϊ��
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
						// ���ͬѧ��ϵԺ
						String classname = userone.getClassone().getClassname();
						System.out.println(entertime);// ��ѧԺ
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
	//��ʾ�༶���԰༶����
	public String showMessage(){
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = myclassService.getcurrPage(page);
		String sql = "from Message where user.classone.classid='" + classid
				+ "' and hostid=0  order by pubtime desc";
		// ��ȡ��ҳ���
		PageModel pageModel = myclassService.findPaging(sql, currPage,
				pageSize, sql);
		List<Message> messagelist=myclassService.getAllMessages(classid);
		request.setAttribute("pageModel", pageModel);
		request.setAttribute("messagelist", messagelist);
		return "showmessage";
	}
	//�������
	public String addMessage(){
		System.out.println(messagecontent);
		System.out.println(code);
		// ȡϵͳ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pubtime = df.format(date);
        Message message=new Message(messagecontent,pubtime,user,code,0);
        myclassService.saveOrUpdate(message);
		return "addmessage";
		
	}
}
