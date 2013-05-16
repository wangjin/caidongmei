package com.caidongmei.alumniassociation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidongmei.alumniassociation.dao.NoticeDAO;
import com.caidongmei.alumniassociation.pojo.Notice;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;

@Service
public class NoticeService {
@Autowired
NoticeDAO noticeDao;
//添加更新简介
public void saveOrUpdate(Notice notice) 
{
	noticeDao.saveOrUpdate(notice);
}
//根据id删除简介
	public void delete(int id) {
		noticeDao.delById(NoticeDAO.REPO_CLASS, id);
	}
	public int getcurrPage(String page){
		int currPage = 1; // 当前页
		
		// 如果page变量不为空则对currPage赋值
		if (page != null) {
			currPage = Integer.parseInt(page);
		}
	    return 	currPage;
	}
	//返回新闻PageModel
		public PageModel findPaging(final String sql,final int currPage, final int pageSize,String sqlcount)
		{
		    return	noticeDao.findPaging(sql, currPage, pageSize, sqlcount);
			
		}
		public String getSql(String title){
			String sql="";
			if(!StringUtil.isNull(title)){
				if(!StringUtil.isNull(sql))
					sql+= " and ";
				sql+= " u.title like '%"+title+"%'";
			}
			if(!StringUtil.isNull(sql)){
				sql = " where "+ sql;
			}
			sql="from Notice u "+sql;
			return sql;
		}
		//根据id,获得对象
		public Notice getNotice(int id){
			return (Notice) noticeDao.loadById(NoticeDAO.REPO_CLASS, id);	
		}
		//根据id获得list
		public List<Notice> getNoticeList(int newsid){
			List<Notice> list = new  ArrayList<Notice>();
			list.add((Notice) noticeDao.loadById(NoticeDAO.REPO_CLASS, newsid));
			return list;
		}
		//获取前6条简介
		public List<Notice> listAllById(String Notice){
			@SuppressWarnings("unchecked")
			List<Notice> newslist=(List<com.caidongmei.alumniassociation.pojo.Notice>)noticeDao.listAllById(Notice);
			List<Notice> noticelisttop=new ArrayList<Notice>();
			for (Notice newsone : newslist) {
				if(noticelisttop.size()!=8)
				{
					noticelisttop.add(newsone);
					
				}
			}
			return noticelisttop;
		}
		
}
