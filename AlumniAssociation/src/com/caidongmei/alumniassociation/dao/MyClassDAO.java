package com.caidongmei.alumniassociation.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.caidongmei.alumniassociation.pojo.ClassDept;
import com.caidongmei.alumniassociation.pojo.ClassOne;
import com.caidongmei.alumniassociation.pojo.ClassPhoto;
import com.caidongmei.alumniassociation.pojo.Photokind;
@SuppressWarnings("all")
@Repository
public class MyClassDAO extends BaseDAO {
	public static final Class<?> REPO_CLASS = ClassOne.class;
	public static final Class<?> REPO_ClassPhoto = ClassPhoto.class;
	// ��Ӱ༶
	public void saveOrUpdate(ClassOne classone) {
		getHibernateTemplate().saveOrUpdate(classone);

	}
    
	public Map<Integer, Integer> getClasses() {
		Map<Integer, Integer> mapclass = new HashMap<Integer, Integer>();

		for (int i = 1900; i < 2014; i++) {
			// ���������ж��ٸ��༶
			String sql = "from ClassOne where entertime='" + i
					+ "' and isCreate=1";
			int o = query(sql).size();
			mapclass.put(i, o);
		}
		// List results =
		// session.find("select count��user�� , avg(user.age) from User as user");
		return mapclass;
	}
	

	// ������ѧ��ݺͰ༶�����ж��༶�Ƿ񱻴���
	public boolean isCreate(String entertime, String classname) {
		boolean flag = true;
		String sql = "from ClassOne where  entertime ='" + entertime
				+ "' and  classname='" + classname + "' and isCreate=1";
		List list = getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			flag = false;
		}
		return flag;
	}

	// 2.�Ѽ���У�ѣ�3.���ݰ༶��������ʾǰ9���༶
	public int getHaveEnterStudent(String s) {
		final String hql = "select sum(peoplecount) from " + s + " as a";
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return count.intValue();
	}

	// ��ʾ�༶��Ƭ
	public List<ClassPhoto> getClassPhotolist(int classid) {
		// ��øð༶���������͵����
		List<Photokind> kindlist = (List<Photokind>) query("from Photokind where classid='"
				+ classid + "'");
		List<ClassPhoto> photolist = new ArrayList<ClassPhoto>();
		// ÿ��������Ϊ�����ȡ��
		for (Photokind kind : kindlist)
		{
			Set<ClassPhoto> set = kind.getClassphotos();// kongzhi
			Iterator<ClassPhoto> it = set.iterator();
			while (it.hasNext()) {
				ClassPhoto c = it.next();
				if (c.getPhotokind().getKindid() == kind.getKindid()
						&& c.getIscover() == 1) {
					photolist.add(c);
				}

			}
		}
                      
		return photolist;
	}
	public List<Photokind> getClassPhotolistNON(int classid) {
		// ��øð༶���������͵����
		List<Photokind> kindlist = (List<Photokind>) query("from Photokind where classid='"
				+ classid + "'");
		List<Photokind> photolist = new ArrayList<Photokind>();
		//û����Ƭ�����
		for (Photokind kind : kindlist)
		{
			
			Set<ClassPhoto> set = kind.getClassphotos();// kongzhi
			if(set.size()==0){
				
					photolist.add(kind);}
		}
                      
		return photolist;
	}
	//������ᣬ��ø�������е���Ƭ
	public List<ClassPhoto> getLevelPhotolist(int kindid) {
		List<ClassPhoto> photolist = new ArrayList<ClassPhoto>();

		List<ClassPhoto> kindlist = (List<ClassPhoto>)query("from ClassPhoto");
		for (ClassPhoto classPhoto : kindlist) {
			if (classPhoto.getPhotokind().getKindid() == kindid) {
				photolist.add(classPhoto);
			}
		}
		return photolist;
	}
	/*public int SearchClassDeptidByName(String classdeptname){
		List<ClassDept> ClassDeptlist = (List<ClassDept>)query("from ClassDept where classdeptname='"+classdeptname+"'");
		return ClassDeptlist.get(0).getClassdeptid();
	}*/
	public List<ClassOne> listAll(String sql) {
		return getHibernateTemplate().find(
				sql );
	}
	
	
}
