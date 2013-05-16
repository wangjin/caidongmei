package com.caidongmei.alumniassociation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.caidongmei.alumniassociation.pojo.BriefInformation;
import com.caidongmei.alumniassociation.pojo.News;
import com.caidongmei.alumniassociation.pojo.Notice;
import com.caidongmei.alumniassociation.service.BriefInformationService;
import com.caidongmei.alumniassociation.service.NewsService;
import com.caidongmei.alumniassociation.service.NoticeService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexBeforeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private NewsService newsService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private BriefInformationService briefService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String getTopNews()throws Exception{
		//获取最新7条新闻
		String News="News";
		List<News> newslist=newsService.listAllById(News);
		request.setAttribute("newslist", newslist);		
		
		//获得前7条校园简介
		String BriefInformation="BriefInformation";
		List<BriefInformation> brieflist=briefService.listAllById(BriefInformation);
		request.setAttribute("brieflist", brieflist);		
		
		//获得前7条公告
		String Notice="Notice";
		List<Notice> noticelist=noticeService.listAllById(Notice);
		request.setAttribute("noticelist", noticelist);	
		
		return "index";
		
	}
}
