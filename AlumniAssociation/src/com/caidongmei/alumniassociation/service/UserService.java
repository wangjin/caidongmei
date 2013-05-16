package com.caidongmei.alumniassociation.service;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidongmei.alumniassociation.dao.UserDAO;
import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.Role;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;

@Service
public class UserService {

	@Autowired
	public UserDAO userDao;

	// �����Ñ������������ԓ�Ñ��Ƿ����
	public User isExistByAccountandPassword(String username, String password) {
		return userDao.isExistByAccountandPassword(username, password);
	}

	public boolean isExistByAccountPassword(String username, String password) {
		return userDao.isExistByAccountPassword(username, password);
	}
   //����id,��ö���
	public User getUser(int id){
		return (User) userDao.loadById(UserDAO.REPO_CLASS1, id);	
	}
	// ����û�
	public void insert(User user) {
		userDao.insert(user);
	}
	//����idɾ���û�
		public void delete(int id) {
			userDao.delById(UserDAO.REPO_CLASS1, id);
		}
	public User getUserByName(String username) {
		List<User> users = userDao.findUserByName(username);
		if (users == null || users.size() == 0 || users.size() > 1) {
			return null;
		}

		return users.get(0);
	}
	public List<User> getUserlistByName(String username) {
		List<User> users = userDao.findUserlistByName(username);
		return users;
	}
	// �����û��������֤��ѯ�û��Ƿ����
	public User isExistByUsernameIdentitycard(String username,
			String identitycard) {
		return userDao.isExistByUsernameIdentitycard(username, identitycard);
	}

	public boolean isExistByUsernameandIdentitycard(String username,
			String identitycard) {
		return userDao.isExistByUsernameandIdentitycard(username, identitycard);

	}

	// �����û���Ϣ
	public void updateUser(User user) {
		userDao.update(user);
	}
	public void updateClassOne(ClassOne classOne) {
		userDao.saveOrUpdate(classOne);
	}
	public void saveOrUpdate(User user) 
	{
		userDao.saveOrUpdate(user);
	}
	// ��ѯ����ϵԺ
	public List<?> listAllDept() {
		return userDao.listAllDept();
	}
   
	// ��ѯ���а༶
	public List<?> listAllClass() {
		return userDao.listAllClass();
	}

	// ���ݰ༶���ֻ�ö���
	public ClassOne getClassOneByName(String classname) {
		return userDao.getClassOneByName(classname);
	}
    //���ݰ༶���ֻ�ð༶����
	public boolean isZeroPeople(String classname,String entertime){
		boolean flag=false;
		ClassOne classone=(ClassOne) (userDao.query("from ClassOne where classname='"+classname+"' and entertime='"+entertime+"'")).get(0);
		if(classone.getPeoplecount()==0){
			flag=true;
		}
		return flag;
	}
	
	
	
	// ����ϵԺ���ֻ��ϵԺ����
	/*
	 * public ClassDept getClassDeptByName(String classname){ return
	 * userDao.getClassDeptByName(classname); }
	 */

	// �����û�PageModel
	public PageModel findPaging(final String sql, final int currPage,
			final int pageSize, String sqlcount) {
		return userDao.findPaging(sql, currPage, pageSize, sqlcount);

	}
	public int getcurrPage(String page){
		int currPage = 1; // ��ǰҳ
		
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
	    return 	currPage;
	}
	public String getSql(String username,String identitycard,String classdept,String classone,String state){
		String sql="";
		int sate=0;
		if(state.equals("δע��")){
			sate=0;
		}
		if(state.equals("���ͨ��")){
			sate=1;
		}
		if(state.equals("�����...")){
			sate=2;
		}
		
		if(!StringUtil.isNull(state)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.state = '"+sate+"'";
		}
		if(!StringUtil.isNull(username)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.username like '%"+username+"%'";
		}
		if(!StringUtil.isNull(identitycard)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.identitycard like '%"+identitycard+"%'";
		}
		if(!StringUtil.isNull(classdept)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.classone.classdept.classdeptname = '"+classdept+"'";
		}
		if(!StringUtil.isNull(classone)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.classone.classname = '"+classone+"'";
		}
		if(!StringUtil.isNull(sql)){
			sql = " where "+ sql;
		}
		sql="from User u "+sql;
		return sql;
	}
	//����ĳ�༶ͨѶ¼
	public InputStream downExcelUser(String classname){
		return userDao.downExcelUser(classname);
	}
	public Role getRole(int i){
		return userDao.getRole(i);
	}

}
