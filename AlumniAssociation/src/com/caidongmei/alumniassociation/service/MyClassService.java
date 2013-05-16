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

	// ��Ӱ༶
	public void saveOrUpdate(ClassOne classone) {
		myclassDao.saveOrUpdate(classone);
	}

	// Ժϵ
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
	// 1.�����Ѿ������༶����
	public int getClassCount() {
		return myclassDao.countAlla("ClassOne");
	}

	// 2.�Ѽ���У��
	public int getHaveEnterStudent() {
		return myclassDao.getHaveEnterStudent("ClassOne");
	}

	// 3.���ݰ༶��������ʾǰ9���༶
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

	// ��ʾĳ������а༶
	@SuppressWarnings("unchecked")
	public List<ClassOne> listLevelClasses(String entertime) {

		return (List<ClassOne>) myclassDao
				.query("from ClassOne where entertime='" + entertime
						+ "' and iscreate=1");
	}

	public int getcurrPage(String page) {
		int currPage = 1; // ��ǰҳ

		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
		return currPage;
	}

	// ��������PageModel
	public PageModel findPaging(final String sql, final int currPage,
			final int pageSize, String sqlcount) {
		return myclassDao.findPaging(sql, currPage, pageSize, sqlcount);

	}

	// ��ð༶���ķ���
	public List<ClassPhoto> getClassPhotolist(int classid) {

		return myclassDao.getClassPhotolist(classid);
	}

	// �������Ƭ�����
	public List<Photokind> getClassPhotolistNON(int classid) {

		return myclassDao.getClassPhotolistNON(classid);
	}

	public List<ClassPhoto> getLevelPhotolist(int kindid) {
		return myclassDao.getLevelPhotolist(kindid);
	}

	// �������
	public void createAlbum(Photokind pk) {
		myclassDao.saveOrUpdate(pk);
	}

	// ������Ƭ
	public void saveOrUpdate(ClassPhoto pk) {
		myclassDao.saveOrUpdate(pk);
	}

	// ������е����
	public List<Photokind> getAllPhotokind(int classid) {
		@SuppressWarnings("unchecked")
		List<Photokind> pklist = (List<Photokind>) myclassDao
				.query("from Photokind where classid='"+classid+"'");
		return pklist;
	}

	// ����kindname�����Ƭid
	public Photokind getPhotokindIdByName(String kindname) {
		@SuppressWarnings("unchecked")
		List<Photokind> pklist = (List<Photokind>) myclassDao
				.query("from Photokind where kindname='" + kindname + "'");
		return pklist.get(0);
	}

	// ϵԺ+���

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
	//��øð༶���е�����
	@SuppressWarnings("unchecked")
	public List<Message> getAllMessages(int classid)
	{
		return (List<Message>) myclassDao.query("from Message where user.classone.classid='" + classid
				+ "'");
	}
	//�������
	public void saveOrUpdate(Message message){
		myclassDao.saveOrUpdate(message);
	}
}
