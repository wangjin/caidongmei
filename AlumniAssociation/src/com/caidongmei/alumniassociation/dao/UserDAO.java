package com.caidongmei.alumniassociation.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.Role;
import com.caidongmei.alumniassociation.pojo.User;
@SuppressWarnings("all")
@Repository
public class UserDAO extends  BaseDAO {
	/**
	 * @author CaiDongmei
	 */
	public static final Class<?> REPO_CLASS1 = User.class;

	// 按照id查找记录

	public User findById(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		return user;
	}
	public void insert(User user){
		getHibernateTemplate().save(user);
	}
	//更新用户信息
	public void update(User user) {
		 getHibernateTemplate().saveOrUpdate(user);
	}
	// 按照account和密码查找记录
	public boolean isExistByAccountPassword(String username, String password) {
		boolean flag = false;
		String sql = "from User where username ='" + username
				+ "'and password='" + password + "'";
		List list = getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			flag = true;
		}
		return flag;
	}
	// 按照account和密码查找记录
	public User isExistByAccountandPassword(String username, String password) {
		User user=new User();
		String sql = "from User where username ='" +username
				+ "'and password='" + password + "'";
		List<User> listone = getHibernateTemplate().find(sql);
		for (User userone:listone) 
		{
			user=userone;
		}
         	return user;
	
	}
	//注册按照身份证和用户名，判断是否合法
	public User isExistByUsernameIdentitycard(String username,String identitycard) {
		User user=new User();
		String sql = "from User where username ='" + username
				+ "'and identitycard='" + identitycard + "'";
		List<User> list = getHibernateTemplate().find(sql);
		for (User userone : list) {
				user=userone;
			}
		return user;
		
	}
	public boolean isExistByUsernameandIdentitycard(String username,String identitycard) {
		boolean flag = false;
		String sql = "from User where username ='" + username
				+ "'and identitycard='" + identitycard + "'";
		List<User> list = getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			flag = true;
		}
		return flag;
	}
	public List<User> findUserByName(String username) {
		String sql = "from User where username ='" + username + "'";
		return getHibernateTemplate().find(sql);
	}

	// 查找表中所有记录

	public List findAll() {
		List list = getHibernateTemplate().find("from User");
		return list;
	}

	public List search(String sql) {
		List list = getHibernateTemplate().find(sql);
		return list;
	}
	
		//查询所有系院
	public List<?> listAllDept() {	
			String sqlstring="from ClassDept";
			return query(sqlstring);
		}
	
	//查询所有班级
		
		public List<?> listAllClass() {	
			String sql="from ClassOne";
			return query(sql);
		}
	public ClassOne getClassOneByName(String classname){
		String sql = "from ClassOne where classname ='" + classname + "'";
		ClassOne classone=new ClassOne();
		List<ClassOne> list = getHibernateTemplate().find(sql);
		for (ClassOne userone : list) 
		{
			classone=userone;
		}
			return classone;
		}
	/*public ClassDept getClassDeptByName(String classdeptname){
		String sql = "from ClassDept where classdeptname ='" + classdeptname + "'";
		ClassDept classdept=new ClassDept();
		List<ClassDept> list = getHibernateTemplate().find(sql);
		for (ClassDept userone : list) 
		{
			classdept=userone;
		}
			return classdept;
		
	}*/
	
	public InputStream downExcelUser(String classname){
		
		
		
		List<User> users =(List<User>)query("from User where isjoinclass=1 and classone.classname='"+classname+"'");
		String destFile = ServletActionContext.getServletContext().getRealPath(
				"download/studentExcel/" + System.currentTimeMillis() + ".xls");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(classname);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("姓名");
		cell = row.createCell(0);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("性别");
		cell = row.createCell(1);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("专业");
		cell = row.createCell(2);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("毕业年份");
		cell = row.createCell(3);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("手机号");
		cell = row.createCell(4);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("联系方式");
		cell = row.createCell(5);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("Email");
		cell = row.createCell(6);
		
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("班级");
		cell = row.createCell(7);
		int i = 1;
		
		for (User user : users) {
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getUsername());
			
			cell = row.createCell(1);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getGender());
			
			cell = row.createCell(2);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getMajor());
			
			cell = row.createCell(3);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getGraduation());
			
			cell = row.createCell(4);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getCellphone());
			
			cell = row.createCell(5);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getContactaddress());
			
			cell = row.createCell(6);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getEmail());
			
			cell = row.createCell(7);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(user.getClassone().getClassname());			
			
			i++;
		}
		try {
			wb.write(new FileOutputStream(new File(destFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			return new FileInputStream(new File(destFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<User> findUserlistByName(String username) {
		 return (List<User>) query("from User where isjoinclass=1 and username like '%"
					+ username + "%'");
		
	}
	public  Role getRole(int i){
		 return (Role)query("from Role where roleid='"+i+"'").get(0);
	}
}
