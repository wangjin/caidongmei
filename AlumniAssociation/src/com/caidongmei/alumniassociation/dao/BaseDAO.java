package com.caidongmei.alumniassociation.dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.caidongmei.alumniassociation.util.PageModel;
@SuppressWarnings("all")
/** ͳһ���ݷ��ʽӿ�ʵ�� */
public class BaseDAO extends HibernateDaoSupport  {
	
	@Resource(name = "hibernateTemplate")
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	
	//��ӳ־û�����
	/*public void insert(Class<?> clazz) {
		getHibernateTemplate().save(clazz);
	}*/
	
	//�޸ĳ־û�����
	public void update(Class<?> clazz) {
		getHibernateTemplate().update(clazz);
	}
	/** ɾ��ָ��ID�ĳ־û����� */
	public void delById(Class<?> clazz, Serializable id) {
		getHibernateTemplate().delete(getHibernateTemplate().load(clazz, id));
	}
	/** ��������ָ���ĳ־û����� */
	public void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	/** װ��ָ��������г־û����� */
	public List<?> listAllById(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.pubtime desc");
	}
	
	public List<?> listAllBy(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.peoplecount desc");
	}
	/** װ��ָ��������г־û����� */
	public List<?> listAll(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz);
	}
	/** ͳ��ָ��������г־û����� */
	public int countAll(String clazz) {
		final String hql = "select count(*) from " + clazz + " as a";
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
	//�����Ѿ������༶��������ע��ո�
	public int countAlla(String clazz) {
		final String hql = "select count(*) from " + clazz + " where iscreate=1";
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
	/** ͳ��ָ����Ĳ�ѯ��� */
	public int countQuery(String hql) {
		final String counthql = hql;
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(counthql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return count.intValue();
	}

	/** ����ָ��ID�ĳ־û����� */
	public Object loadById(Class<?> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/** �������������ĳ־û����� */
	public Object loadObject(String hql) {
		final String hql1 = hql;
		Object obj = null;
		List<?> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql1);
						return query.list();
					}
				});
		if (list.size() > 0)
			obj = list.get(0);
		return obj;
	}

	/** ��ѯָ��������������ĳ־û����� */
	public List<?> query(String hql) {
		final String hql1 = hql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
	}


	//��ҳ
	public PageModel findPaging(final String sql,final int currPage, final int pageSize,String sqlcount) {
		 PageModel pageModel = null;
		List<?> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(sql);
						query.setMaxResults(pageSize);
						query.setFirstResult((currPage - 1) * pageSize);
						List<?> list = query.list();
						if (!Hibernate.isInitialized(list))
							Hibernate.initialize(list);
						session.close();
						return list;
					
						
					}
				});
		
		pageModel = new PageModel();		//ʵ����pageModel
		pageModel.setCurrPage(currPage);	//���õ�ǰҳ
		pageModel.setList(list);			//���ý����
		pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
		//�����ܼ�¼��
		pageModel.setTotalRecords(getTotalRecords(sqlcount));
		return pageModel;
	}
	//���������
		public int getTotalRecords(String sql) {
			// �����ܼ�¼��List list = getHibernateTemplate().find("from Role");
			List list = getHibernateTemplate().find(sql);
			return list.size();	
		}
		//
		
}
