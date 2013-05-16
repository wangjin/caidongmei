package com.caidongmei.alumniassociation.dao;

import org.springframework.stereotype.Repository;

import com.caidongmei.alumniassociation.pojo.BriefInformation;

@Repository
public class BriefInformationDAO extends BaseDAO{
	public static final Class<?> REPO_CLASS =BriefInformation.class;
	//��ӣ����¼��
	public void saveOrUpdate(BriefInformation  brief) {
		getHibernateTemplate().saveOrUpdate(brief);
	
}
}