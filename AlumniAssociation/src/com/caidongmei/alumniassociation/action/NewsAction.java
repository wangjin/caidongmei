package com.caidongmei.alumniassociation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.caidongmei.alumniassociation.pojo.News;
import com.caidongmei.alumniassociation.service.NewsService;
import com.caidongmei.alumniassociation.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private NewsService newsService;
	HttpServletRequest request = ServletActionContext.getRequest();

	private String newstitle;

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	private String pubtime;
	private String newscontent;

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getNewscontent() {
		return newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	// 显示新闻
	public String showNews() throws Exception {

		String page = request.getParameter("currPage");
		int selectshowid = 0;
		if (request.getParameter("selectshowid") != null) {
			selectshowid = Integer.parseInt(request
					.getParameter("selectshowid"));
		}
		// 每页显示4条记录
		int pageSize = 6;
		int currPage = newsService.getcurrPage(page);
		String sql = "from News";

		// 获取分页组件
		PageModel pageModel = newsService.findPaging(sql, currPage, pageSize,
				sql);
		System.out.println(pageModel.getLastPage());
		request.setAttribute("pageModel", pageModel);
		// 全部的值显示在前台页面
		if (selectshowid == 2) {
			return "showallnews";
		} else {
			// 后台显示全部新闻
			return "shownews";
		}
	}

	public String deleteNews() throws Exception {
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		newsService.delete(newsid);
		return "deletenews";

	}

	/*
	 * // 添加新闻 public String addNews() throws Exception {
	 * 
	 * return "addnews"; }
	 */

	// 按条件查询新闻
	public String searchNews() throws Exception {
		int selectid = 0;
		if (request.getParameter("selectid") != null)

		{
			selectid = Integer.parseInt(request.getParameter("selectid"));
		}

		String page = request.getParameter("currPage");
		String newstitle = request.getParameter("newstitle");
		System.out.println("===newstitle" + newstitle);
		// 乱码解决
		// newstitle=new String(newstitle.trim().getBytes("ISO8859-1"),"utf-8");
		String pubtime = request.getParameter("pubtime");
		// 每页显示4条记录
		int pageSize = 4;
		int currPage = newsService.getcurrPage(page);
		String sql = newsService.getSql(newstitle, pubtime);
		// 获取分页组件
		PageModel pageModel = newsService.findPaging(sql, currPage, pageSize,
				sql);
		System.out.println(pageModel.getLastPage());
		request.setAttribute("pageModel", pageModel);
		if (selectid == 1) {
			return "showsearchnews";// 显示所有，然后按条件查询
		} else
			return "searchnews";

	}

	public String searchOneById() throws Exception {
		int selectid = Integer.parseInt(request.getParameter("selectid"));
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		List<News> newslist = newsService.getNews(newsid);
		request.setAttribute("newslist", newslist);
		if (selectid == 1) {
			// int
			// x=newslist.get(0).getBrowsevolume()+1;未实现，添加一个方法使得getBrowsevolume+1
			return "searchonenews";
		} else if (selectid == 2)// 注意=2的值，用于未写完的更新
		{
			return "updatenews";
		} else if (selectid == 3) {
			return "xinwen";
		} else if (selectid == 4) {
			return "backlistnews";
		} else {
			return "error";
		}
	}

	// 更新新闻信息
	public String updateNews() throws Exception {
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		News news = newsService.getNewsOne(newsid);
		news.setNewsid(newsid);
		news.setNewstitle(newstitle);
		if (newscontent != null && newscontent.length() > 0) {
			news.setNewscontent(newscontent);
		}
		newsService.updateNew(news);
		return "deletenews";
	}

}
