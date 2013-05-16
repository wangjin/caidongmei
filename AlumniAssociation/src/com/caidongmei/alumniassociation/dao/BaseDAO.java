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
/** 统一数据访问接口实现 */
public class BaseDAO extends HibernateDaoSupport  {
	
	@Resource(name = "hibernateTemplate")
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	
	//添加持久化对象
	/*public void insert(Class<?> clazz) {
		getHibernateTemplate().save(clazz);
	}*/
	
	//修改持久化对象
	public void update(Class<?> clazz) {
		getHibernateTemplate().update(clazz);
	}
	/** 删除指定ID的持久化对象 */
	public void delById(Class<?> clazz, Serializable id) {
		getHibernateTemplate().delete(getHibernateTemplate().load(clazz, id));
	}
	/** 保存或更新指定的持久化对象 */
	public void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	/** 装载指定类的所有持久化对象 */
	public List<?> listAllById(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.pubtime desc");
	}
	
	public List<?> listAllBy(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.peoplecount desc");
	}
	/** 装载指定类的所有持久化对象 */
	public List<?> listAll(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz);
	}
	/** 统计指定类的所有持久化对象 */
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
	//查找已经创建班级的总数，注意空格
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
	/** 统计指定类的查询结果 */
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

	/** 加载指定ID的持久化对象 */
	public Object loadById(Class<?> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	/** 加载满足条件的持久化对象 */
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

	/** 查询指定类的满足条件的持久化对象 */
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


	//分页
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
		
		pageModel = new PageModel();		//实例化pageModel
		pageModel.setCurrPage(currPage);	//设置当前页
		pageModel.setList(list);			//设置结果集
		pageModel.setPageSize(pageSize);	//设置每页记录数
		//设置总记录数
		pageModel.setTotalRecords(getTotalRecords(sqlcount));
		return pageModel;
	}
	//获得总数据
		public int getTotalRecords(String sql) {
			// 返回总记录数List list = getHibernateTemplate().find("from Role");
			List list = getHibernateTemplate().find(sql);
			return list.size();	
		}
		//
		
}
