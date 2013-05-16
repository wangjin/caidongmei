package com.caidongmei.alumniassociation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.caidongmei.alumniassociation.dao.MyClassDAO;
import com.caidongmei.alumniassociation.pojo.ClassDept;
import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.ClassPhoto;
import com.caidongmei.alumniassociation.pojo.Message;
import com.caidongmei.alumniassociation.pojo.Photokind;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;

@Service
public class MyClassService {
	@Autowired
	MyClassDAO myclassDao;

	// 添加班级
	public void saveOrUpdate(ClassOne classone) {
		myclassDao.saveOrUpdate(classone);
	}

	// 院系
	public void saveOrUpdate(ClassDept classdept) {
		myclassDao.saveOrUpdate(classdept);
	}

	public Map<Integer, Integer> getClasses() {
		return myclassDao.getClasses();
	}

	public Boolean isCreate(String entertime, String classname) {
		return myclassDao.isCreate(entertime, classname);
	}

	public ClassOne getClassOne(String entertime, String classname) {
		String sql = "from ClassOne where entertime='" + entertime
				+ "' and classname='" + classname + "'";
		return (ClassOne) myclassDao.query(sql).get(0);
	}

	/*
	 * public int getClassCount() { return myclassDao.countAll("ClassOne"); }
	 */
	// 1.计算已经创建班级总数
	public int getClassCount() {
		return myclassDao.countAlla("ClassOne");
	}

	// 2.已加入校友
	public int getHaveEnterStudent() {
		return myclassDao.getHaveEnterStudent("ClassOne");
	}

	// 3.根据班级人数，显示前9个班级
	public List<ClassOne> listTopNine(String ClassOne) {
		@SuppressWarnings("unchecked")
		List<ClassOne> newslist = (List<com.caidongmei.alumniassociation.pojo.ClassOne>) myclassDao
				.listAllBy(ClassOne);
		List<ClassOne> newlisttop = new ArrayList<ClassOne>();
		for (ClassOne newsone : newslist) {
			if (newlisttop.size() != 9) {
				newlisttop.add(newsone);

			}
		}
		return newlisttop;
	}

	// 显示某届的所有班级
	@SuppressWarnings("unchecked")
	public List<ClassOne> listLevelClasses(String entertime) {

		return (List<ClassOne>) myclassDao
				.query("from ClassOne where entertime='" + entertime
						+ "' and iscreate=1");
	}

	public int getcurrPage(String page) {
		int currPage = 1; // 当前页

		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		return currPage;
	}

	// 返回新闻PageModel
	public PageModel findPaging(final String sql, final int currPage,
			final int pageSize, String sqlcount) {
		return myclassDao.findPaging(sql, currPage, pageSize, sqlcount);

	}

	// 获得班级相册的封面
	public List<ClassPhoto> getClassPhotolist(int classid) {

		return myclassDao.getClassPhotolist(classid);
	}

	// 获得无照片的相册
	public List<Photokind> getClassPhotolistNON(int classid) {

		return myclassDao.getClassPhotolistNON(classid);
	}

	public List<ClassPhoto> getLevelPhotolist(int kindid) {
		return myclassDao.getLevelPhotolist(kindid);
	}

	// 创建相册
	public void createAlbum(Photokind pk) {
		myclassDao.saveOrUpdate(pk);
	}

	// 创建照片
	public void saveOrUpdate(ClassPhoto pk) {
		myclassDao.saveOrUpdate(pk);
	}

	// 获得所有的相册
	public List<Photokind> getAllPhotokind(int classid) {
		@SuppressWarnings("unchecked")
		List<Photokind> pklist = (List<Photokind>) myclassDao
				.query("from Photokind where classid='"+classid+"'");
		return pklist;
	}

	// 根据kindname获得照片id
	public Photokind getPhotokindIdByName(String kindname) {
		@SuppressWarnings("unchecked")
		List<Photokind> pklist = (List<Photokind>) myclassDao
				.query("from Photokind where kindname='" + kindname + "'");
		return pklist.get(0);
	}

	// 系院+年份

	@SuppressWarnings("unchecked")
	public List<ClassOne> listClasses(String entertime, String keyword) {
		return (List<ClassOne>) myclassDao.query(getSql(entertime, keyword));
	}

	@SuppressWarnings("unchecked")
	public List<ClassOne> listClass() {
		return (List<ClassOne>) myclassDao
				.query("from ClassOne where iscreate=1");
	}

	@SuppressWarnings("unchecked")
	public ClassOne listClasses1(String entertime, String keyword) {
		List<ClassOne> classonelist = (List<ClassOne>) myclassDao
				.query(getSql1(entertime, keyword));
		if (classonelist.size() > 0) {
			return classonelist.get(0);
		} else
			return null;
	}

	public String getSql(String entertime, String keyword) {
		String sql = "";
		if (!StringUtil.isNull(entertime) && entertime.length() > 0) {
			if (!StringUtil.isNull(sql))
				sql += " and ";
			sql += " u.entertime like '%" + entertime + "%'";
		}
		if (!StringUtil.isNull(keyword)) {
			if (!StringUtil.isNull(sql))
				sql += " and ";
			sql += " u.classdept.classdeptname like '%" + keyword + "%'";
		}

		if (!StringUtil.isNull(sql)) {
			sql = " where u.iscreate=1 and " + sql;
		}

		sql = "from ClassOne u " + sql;
		return sql;
	}

	public String getSql1(String entertime, String keyword) {
		String sql = "";
		if (!StringUtil.isNull(entertime) && entertime.length() > 0) {
			if (!StringUtil.isNull(sql))
				sql += " and ";
			sql += " u.entertime like '%" + entertime + "%'";
		}
		if (!StringUtil.isNull(keyword)) {
			if (!StringUtil.isNull(sql))
				sql += " and ";
			sql += " u.classname like '%" + keyword + "%'";
		}

		if (!StringUtil.isNull(sql)) {
			sql = " where u.iscreate=1 and " + sql;
		}

		sql = "from ClassOne u " + sql;
		return sql;
	}
	//获得该班级所有的留言
	@SuppressWarnings("unchecked")
	public List<Message> getAllMessages(int classid)
	{
		return (List<Message>) myclassDao.query("from Message where user.classone.classid='" + classid
				+ "'");
	}
	//添加留言
	public void saveOrUpdate(Message message){
		myclassDao.saveOrUpdate(message);
	}
}
