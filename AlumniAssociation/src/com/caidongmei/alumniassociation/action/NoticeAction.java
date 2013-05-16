package com.caidongmei.alumniassociation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.caidongmei.alumniassociation.pojo.Notice;
import com.caidongmei.alumniassociation.service.NoticeService;
import com.caidongmei.alumniassociation.util.PageModel;

public class NoticeAction {
	@Autowired
	NoticeService noticeService;
	HttpServletRequest request = ServletActionContext.getRequest();
	private int noticeid;
	private String title;
	private String content;
	private String pubtime;
	private int select;
	private int selectid;
    private int showbeforeid;
	public int getShowbeforeid() {
		return showbeforeid;
	}
	public void setShowbeforeid(int showbeforeid) {
		this.showbeforeid = showbeforeid;
	}
	public int getSelectid() {
		return selectid;
	}
	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
		//��ʾ���м��
	public String showNotice() throws Exception {
			
			String page = request.getParameter("currPage");	
			// ÿҳ��ʾ6����¼
		    int pageSize = 6; 
		    int	currPage =noticeService.getcurrPage(page);
			String sql = "from Notice";
			// ��ȡ��ҳ���
			PageModel pageModel = noticeService.findPaging(sql, currPage, pageSize,
					sql);
			request.setAttribute("pageModel", pageModel);
			
			
			if(select==1){
				return "dynamicinformation";
			}
			else if(select==2)//ǰ̨��ʾ������Ϣ�б�
			{
				return "showallnotice";
			}
			else 
				return "shownotice";
			
			}
		//ɾ�����
		public String deleteNotice() throws Exception {
			String[] s=request.getParameterValues("keep[]");
			int noticeid=0;
			  for(int i=0;i<s.length;i++)
			    {
				  noticeid=Integer.parseInt(s[i]);				  
		       	  noticeService.delete(noticeid);
		       	  }
			    return "deletenotice";
			
		}
		//����id���list
		public String searchOneBynoticeid() throws Exception {
			List<Notice> noticelist=noticeService.getNoticeList(noticeid);
			request.setAttribute("noticelist", noticelist);
			if(selectid==1)
			{
			//��̨��ʾ������Ϣ�������޸�
				return "searchonenotice";
			}
			else if(selectid==2)//ǰ̨ҳ����ʾ������Ϣ
			{
				return "shownoticeone";
			}
			else if(selectid==3){
				return "fanhuisuoyou";//ǰ̨�б�����ʾ�������ر� ���ص�������Ϣ
			}
			else{
				return "error";
			}
		}
		
		//�޸ļ��
		public String updateNotice()throws Exception {
			Notice brief=noticeService.getNotice(noticeid);
			brief.setContent(content);
			brief.setPubtime(pubtime);
			brief.setTitle(title);
			noticeService.saveOrUpdate(brief);
			return "deletenotice";
		}
		//��������ѯ���
		public String searchNotice() throws Exception {
			String page = request.getParameter("currPage");
			// ÿҳ��ʾ6����¼
		    int pageSize = 6; 
		    int	currPage =noticeService.getcurrPage(page);
			String sql = noticeService.getSql(title);
			// ��ȡ��ҳ���
			PageModel pageModel = noticeService.findPaging(sql, currPage, pageSize,
					sql);
			request.setAttribute("pageModel", pageModel);
			if(showbeforeid==1){
				return "showallnotice";
			}
			else
				return "shownotice";

		}
}
