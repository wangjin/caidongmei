package com.caidongmei.alumniassociation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.caidongmei.alumniassociation.pojo.SchoolPhoto;
import com.caidongmei.alumniassociation.service.SchoolPhotoService;
import com.caidongmei.alumniassociation.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class SchoolPhotoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	SchoolPhotoService schoolphotoService;
	HttpServletRequest request = ServletActionContext.getRequest();
	private int photoid;
	private String name;
	private String url;
	private String pubtime;
	private int select;
	private int selectid;
    private int showid;
	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public int getSelectid() {
		return selectid;
	}

	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}

	public int getPhotoid() {
		return photoid;
	}

	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	// ��ʾ���м��
	public String showPhoto() throws Exception {
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = schoolphotoService.getcurrPage(page);
		String sql = "from SchoolPhoto";
		// ��ȡ��ҳ���
		PageModel pageModel = schoolphotoService.findPaging(sql, currPage,
				pageSize, sql);
		request.setAttribute("pageModel", pageModel);
		if(showid==1){
			return "photo";
		}
		else 
			return "showphoto";

	}

	// ɾ��
	public String deletePhoto() throws Exception {
		String[] s = request.getParameterValues("keep[]");
		int photoid = 0;
		for (int i = 0; i < s.length; i++) {
			photoid = Integer.parseInt(s[i]);
			System.out.println(photoid);
			schoolphotoService.delete(photoid);
		}
		return "deletephoto";

	}

	// ����id���list
	public String searchOneByphotoid() throws Exception {
		List<SchoolPhoto> schoolphotolist = schoolphotoService
				.getSchoolPhotoList(photoid);
		request.setAttribute("photolist", schoolphotolist);
		if (selectid == 1) {
			// ��̨��ʾ������Ϣ�������޸�
			return "searchonephoto";
		} else if (selectid == 2)// ǰ̨ҳ����ʾ������Ϣ
		{
			return "showphotoone";
		} else if (selectid == 3) {
			return "showphotoonebyid";
		} else {
			return "error";
		}
	}

	// �޸�
	public String updatePhoto() throws Exception {
		SchoolPhoto brief = schoolphotoService.getSchoolPhoto(photoid);
		brief.setName(name);
		brief.setPubtime(pubtime);
		schoolphotoService.saveOrUpdate(brief);
		return "deletephoto";
	}

	// ��������ѯ���
	public String searchPhoto() throws Exception {
		String page = request.getParameter("currPage");
		// ÿҳ��ʾ6����¼
		int pageSize = 6;
		int currPage = schoolphotoService.getcurrPage(page);
		String sql = schoolphotoService.getSql(name);
		// ��ȡ��ҳ���
		PageModel pageModel = schoolphotoService.findPaging(sql, currPage,
				pageSize, sql);
		request.setAttribute("pageModel", pageModel);
		return "showphoto";

	}
}
