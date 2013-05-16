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

	// 跟居用戶名和密码查找該用戶是否存在
	public User isExistByAccountandPassword(String username, String password) {
		return userDao.isExistByAccountandPassword(username, password);
	}

	public boolean isExistByAccountPassword(String username, String password) {
		return userDao.isExistByAccountPassword(username, password);
	}
   //根据id,获得对象
	public User getUser(int id){
		return (User) userDao.loadById(UserDAO.REPO_CLASS1, id);	
	}
	// 添加用户
	public void insert(User user) {
		userDao.insert(user);
	}
	//根据id删除用户
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
	// 根据用户名和身份证查询用户是否存在
	public User isExistByUsernameIdentitycard(String username,
			String identitycard) {
		return userDao.isExistByUsernameIdentitycard(username, identitycard);
	}

	public boolean isExistByUsernameandIdentitycard(String username,
			String identitycard) {
		return userDao.isExistByUsernameandIdentitycard(username, identitycard);

	}

	// 更新用户信息
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
	// 查询所有系院
	public List<?> listAllDept() {
		return userDao.listAllDept();
	}
   
	// 查询所有班级
	public List<?> listAllClass() {
		return userDao.listAllClass();
	}

	// 根据班级名字获得对象
	public ClassOne getClassOneByName(String classname) {
		return userDao.getClassOneByName(classname);
	}
    //根据班级名字获得班级人数
	public boolean isZeroPeople(String classname,String entertime){
		boolean flag=false;
		ClassOne classone=(ClassOne) (userDao.query("from ClassOne where classname='"+classname+"' and entertime='"+entertime+"'")).get(0);
		if(classone.getPeoplecount()==0){
			flag=true;
		}
		return flag;
	}
	
	
	
	// 更加系院名字获得系院对象
	/*
	 * public ClassDept getClassDeptByName(String classname){ return
	 * userDao.getClassDeptByName(classname); }
	 */

	// 返回用户PageModel
	public PageModel findPaging(final String sql, final int currPage,
			final int pageSize, String sqlcount) {
		return userDao.findPaging(sql, currPage, pageSize, sqlcount);

	}
	public int getcurrPage(String page){
		int currPage = 1; // 当前页
		
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
	    return 	currPage;
	}
	public String getSql(String username,String identitycard,String classdept,String classone,String state){
		String sql="";
		int sate=0;
		if(state.equals("未注册")){
			sate=0;
		}
		if(state.equals("审核通过")){
			sate=1;
		}
		if(state.equals("待审核...")){
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
	//下载某班级通讯录
	public InputStream downExcelUser(String classname){
		return userDao.downExcelUser(classname);
	}
	public Role getRole(int i){
		return userDao.getRole(i);
	}

}
