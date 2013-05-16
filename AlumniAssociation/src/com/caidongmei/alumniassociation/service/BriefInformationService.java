package com.caidongmei.alumniassociation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidongmei.alumniassociation.dao.BriefInformationDAO;
import com.caidongmei.alumniassociation.pojo.BriefInformation;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;
@Service
public class BriefInformationService {
@Autowired
public BriefInformationDAO birefDao;
//添加更新简介
public void saveOrUpdate(BriefInformation brief) 
{
	birefDao.saveOrUpdate(brief);
}
//根据id删除简介
	public void delete(int id) {
		birefDao.delById(BriefInformationDAO.REPO_CLASS, id);
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
		    return	birefDao.findPaging(sql, currPage, pageSize, sqlcount);
			
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
			sql="from BriefInformation u "+sql;
			return sql;
		}
		//根据id,获得对象
		public BriefInformation getBrief(int id){
			return (BriefInformation) birefDao.loadById(BriefInformationDAO.REPO_CLASS, id);	
		}
		//根据id获得list
		public List<BriefInformation> getBriefList(int newsid){
			List<BriefInformation> list = new  ArrayList<BriefInformation>();
			list.add((BriefInformation) birefDao.loadById(BriefInformationDAO.REPO_CLASS, newsid));
			return list;
		}
		//获取前6条简介
		public List<BriefInformation> listAllById(String BriefInformation){
			@SuppressWarnings("unchecked")
			List<BriefInformation> newslist=(List<com.caidongmei.alumniassociation.pojo.BriefInformation>)birefDao.listAllById(BriefInformation);
			List<BriefInformation> brieflisttop=new ArrayList<BriefInformation>();
			for (BriefInformation newsone : newslist) {
				if(brieflisttop.size()!=8)
				{
					brieflisttop.add(newsone);
					
				}
			}
			return brieflisttop;
		}
}
