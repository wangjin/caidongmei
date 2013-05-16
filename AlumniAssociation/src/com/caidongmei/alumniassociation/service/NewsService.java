package com.caidongmei.alumniassociation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidongmei.alumniassociation.dao.NewsDAO;
import com.caidongmei.alumniassociation.pojo.News;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;
@SuppressWarnings("all")
@Service
public class NewsService {
	
	@Autowired
	public NewsDAO newsDao;
	public void insert(News news) 
	{
		newsDao.insert(news);
	}
	//��������PageModel
	public PageModel findPaging(final String sql,final int currPage, final int pageSize,String sqlcount)
	{
	    return	newsDao.findPaging(sql, currPage, pageSize, sqlcount);
		
	}
	//����idɾ������
	public void delete(int id) {
		newsDao.delById(NewsDAO.REPO_CLASS, id);
	}
	public String getSql(String newstitle,String pubtime){
		String sql="";
		if(!StringUtil.isNull(newstitle)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.newstitle like '%"+newstitle+"%'";
		}
		if(!StringUtil.isNull(pubtime)){
			if(!StringUtil.isNull(sql))
				sql+= " and ";
			sql+= " u.pubtime like '%"+pubtime+"%'";
		}
		
		if(!StringUtil.isNull(sql)){
			sql = " where "+ sql;
		}
		sql="from News u "+sql;
		return sql;
	}
	public int getcurrPage(String page){
		int currPage = 1; // ��ǰҳ
		
		// ���page������Ϊ�����currPage��ֵ
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
	    return 	currPage;
	}
	public List<News> getNews(int newsid){
		List<News> list = new  ArrayList<News>();
		list.add((News) newsDao.loadById(NewsDAO.REPO_CLASS, newsid));
		return list;
	}
	//��ȡǰ6������
	public List<News> listAllById(String News){
		List<News> newslist=(List<com.caidongmei.alumniassociation.pojo.News>)newsDao.listAllById(News);
		List<News> newlisttop=new ArrayList<News>();
		for (News newsone : newslist) {
			if(newlisttop.size()!=8)
			{
				newlisttop.add(newsone);
				
			}
		}
		return newlisttop;
	}
	public void saveOrUpdate(Object obj){
		
		newsDao.saveOrUpdate(obj);
	}
	//����id���������Ŷ���
	public  News getNewsOne(int id){
		return (News)newsDao.loadById(NewsDAO.REPO_CLASS, id);
		
	}
	public void updateNew(News news) {
		newsDao.update(news);
	}
}
