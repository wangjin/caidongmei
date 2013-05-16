package com.caidongmei.alumniassociation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.caidongmei.alumniassociation.pojo.BriefInformation;
import com.caidongmei.alumniassociation.service.BriefInformationService;
import com.caidongmei.alumniassociation.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class BriefInformationAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int briefid;
	private String title;
	private String content;
	private String pubtime;
	private int select;
	private int showbriefid;
	public int getShowbriefid() {
		return showbriefid;
	}
	public void setShowbriefid(int showbriefid) {
		this.showbriefid = showbriefid;
	}
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	private int selectid;
	public int getSelectid() {
		return selectid;
	}
	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBriefid() {
		return briefid;
	}
	public void setBriefid(int briefid) {
		this.briefid = briefid;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	BriefInformationService briefService;
	//显示所有简介
	public String showBrief() throws Exception {
		
		String page = request.getParameter("currPage");	
		// 每页显示6条记录
	    int pageSize = 6; 
	    int	currPage =briefService.getcurrPage(page);
		String sql = "from BriefInformation";
		// 获取分页组件
		PageModel pageModel = briefService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);
		
		
		if(select==1){
			return "dynamicinformation";
		}
		else 
			return "showbrief";
		
		}
	//删除简介
	public String deleteBrief() throws Exception {
		briefService.delete(briefid);
		    return "deletebrief";
		
	}
	//根据id获得list
	public String searchOneByBriefId() throws Exception {
		List<BriefInformation> brieflist=briefService.getBriefList(briefid);
		request.setAttribute("brieflist", brieflist);
		if(selectid==1)
		{
		//后台显示单条信息，进行修改
			return "searchonebrief";
		}
		else if(selectid==2)//前台页面显示单条信息
		{
			return "showbriefone";
		}
		else if(selectid==3){
			return "showbriefonebyid";
		}
		else{
			return "error";
		}
	}
	
	//修改简介
	public String updateBrief()throws Exception {
		BriefInformation brief=briefService.getBrief(briefid);
		brief.setContent(content);
		brief.setPubtime(pubtime);
		brief.setTitle(title);
		briefService.saveOrUpdate(brief);
		return "deletebrief";
	}
	//按条件查询简介
	public String searchBrief() throws Exception {
		String page = request.getParameter("currPage");
		// 每页显示6条记录
	    int pageSize = 6; 
	    int	currPage =briefService.getcurrPage(page);
		String sql = briefService.getSql(title);
		// 获取分页组件
		PageModel pageModel = briefService.findPaging(sql, currPage, pageSize,
				sql);
		request.setAttribute("pageModel", pageModel);
		if(showbriefid==1){
			return "dynamicinformation";
		}
		else
			return "showbrief";

	}
}
