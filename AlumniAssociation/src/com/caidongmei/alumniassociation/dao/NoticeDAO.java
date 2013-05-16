package com.caidongmei.alumniassociation.dao;

import org.springframework.stereotype.Repository;

import com.caidongmei.alumniassociation.pojo.Notice;

@Repository
public class NoticeDAO extends BaseDAO{
	public static final Class<?> REPO_CLASS =Notice.class;
	//添加，更新公告
	public void saveOrUpdate(Notice  notice) {
		getHibernateTemplate().saveOrUpdate(notice);
	
}
}
