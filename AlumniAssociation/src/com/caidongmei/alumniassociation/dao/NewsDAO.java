package com.caidongmei.alumniassociation.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.caidongmei.alumniassociation.pojo.News;
@Repository
public class NewsDAO extends BaseDAO{

	public static final Class<?> REPO_CLASS = News.class;
	
	/**
	 * @author CaiDongmei
	 */

	// ∞¥’’id≤È’“º«¬º
	public News findById(int id) {
		News news=(News) getHibernateTemplate().get(News.class, id);
		return news;
	}
	
	public List<?> listAll(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.pubtime desc");
	}
	public void insert(News  news) {
		getHibernateTemplate().save(news);
	}
	public void update(News news) {
		 getHibernateTemplate().saveOrUpdate(news);
	}
}
