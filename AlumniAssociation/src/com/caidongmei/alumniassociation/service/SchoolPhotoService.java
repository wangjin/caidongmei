package com.caidongmei.alumniassociation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.caidongmei.alumniassociation.dao.SchoolPhotoDAO;
import com.caidongmei.alumniassociation.pojo.SchoolPhoto;
import com.caidongmei.alumniassociation.util.PageModel;
import com.caidongmei.alumniassociation.util.StringUtil;

@Service
public class SchoolPhotoService {
@Autowired
public SchoolPhotoDAO schoolphotoDao;
//添加更新校园风景照片
public void saveOrUpdate(SchoolPhoto schoolPhoto) 
{
	schoolphotoDao.saveOrUpdate(schoolPhoto);
}
//根据id删除照片
	public void delete(int id) {
		schoolphotoDao.delById(SchoolPhotoDAO.REPO_CLASS, id);
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
		    return	schoolphotoDao.findPaging(sql, currPage, pageSize, sqlcount);
			
		}
		public String getSql(String name){
			String sql="";
			if(!StringUtil.isNull(name)){
				if(!StringUtil.isNull(sql))
					sql+= " and ";
				sql+= " u.name like '%"+name+"%'";
			}
			if(!StringUtil.isNull(sql)){
				sql = " where "+ sql;
			}
			sql="from SchoolPhoto u "+sql;
			return sql;
		}
		//根据id,获得对象
		public SchoolPhoto getSchoolPhoto(int id){
			return (SchoolPhoto) schoolphotoDao.loadById(SchoolPhotoDAO.REPO_CLASS, id);	
		}
		//根据id获得list
		public List<SchoolPhoto> getSchoolPhotoList(int newsid){
			List<SchoolPhoto> list = new  ArrayList<SchoolPhoto>();
			list.add((SchoolPhoto) schoolphotoDao.loadById(SchoolPhotoDAO.REPO_CLASS, newsid));
			return list;
		}
		//获取前6条简介
		public List<SchoolPhoto> listAllById(String SchoolPhoto){
			@SuppressWarnings("unchecked")
			List<SchoolPhoto> newslist=(List<com.caidongmei.alumniassociation.pojo.SchoolPhoto>)schoolphotoDao.listAllById(SchoolPhoto);
			List<SchoolPhoto> SchoolPhotolisttop=new ArrayList<SchoolPhoto>();
			for (SchoolPhoto newsone : newslist) {
				if(SchoolPhotolisttop.size()!=6)
				{
					SchoolPhotolisttop.add(newsone);
					
				}
			}
			return SchoolPhotolisttop;
		}

}
