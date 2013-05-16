package com.caidongmei.alumniassociation.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.caidongmei.alumniassociation.pojo.BriefInformation;
import com.caidongmei.alumniassociation.pojo.ClassPhoto;
import com.caidongmei.alumniassociation.pojo.News;
import com.caidongmei.alumniassociation.pojo.Notice;
import com.caidongmei.alumniassociation.pojo.Photokind;
import com.caidongmei.alumniassociation.pojo.SchoolPhoto;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.service.BriefInformationService;
import com.caidongmei.alumniassociation.service.MyClassService;
import com.caidongmei.alumniassociation.service.NewsService;
import com.caidongmei.alumniassociation.service.NoticeService;
import com.caidongmei.alumniassociation.service.SchoolPhotoService;
import com.caidongmei.alumniassociation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("all")
public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 572146812454l;
	private static final int BUFFER_SIZE = 16 * 1024;
	HttpServletRequest request = ServletActionContext.getRequest();
	private File myFile;
	private String contentType;
	private InputStream inputstream;
	private String fileName;
	private String imageFileName;
	private String photoname;
	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	@Autowired
	private NewsService newsService;
	@Autowired
	private BriefInformationService briefService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private SchoolPhotoService schoolphotoService;
	@Autowired
	private UserService userService;
	@Autowired
	private MyClassService myclassService;
	private String newstitle;
	private String newscontent;
	private String method;
    private String kindname;
	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNewscontent() {
		return newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public void setMyFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setMyFileFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getExtention(String fileName) {
		if (fileName != null) {
			int pos = fileName.lastIndexOf(".");
			return fileName.substring(pos);
		} else {

			return null;

		}
	}

	public String uploadNews() throws Exception {
		imageFileName = new Date().getTime() + getExtention(fileName);
		// 取系统当前时间
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pubtime = df.format(date);

		File imageFile = new File(ServletActionContext.getServletContext()
				.getRealPath("/NewsImages") + "/" + imageFileName);
		String url = "/NewsImages" + "/" + imageFileName;

		copy(myFile, imageFile);
		if (method.equals("1")) {
			News news = new News(newstitle, newscontent, pubtime, 0, url);// url长度不够数据库设计时候DataIntegrityViolationException
			newsService.insert(news);
		}
		if (method.equals("2")) {
			BriefInformation brief = new BriefInformation(newstitle,
					newscontent, pubtime, url);
			briefService.saveOrUpdate(brief);
		}
		if (method.equals("3")) {
			Notice notice = new Notice(newstitle, newscontent, url, pubtime);
			noticeService.saveOrUpdate(notice);
		}
		if (method.equals("4")) {
			SchoolPhoto schoolphoto = new SchoolPhoto(newstitle, pubtime, url);
			schoolphotoService.saveOrUpdate(schoolphoto);
		}
		if (method.equals("5")) {
			User user = (User) request.getSession().getAttribute("user");
			user.setRemark(url);
			userService.saveOrUpdate(user);
			return "updatepersonphoto";
		}
		if (method.equals("6")) {
			//System.out.println("==kindid"+kindname);
			User user = (User) request.getSession().getAttribute("user");
			Photokind pk=new Photokind();
			
			pk=myclassService.getPhotokindIdByName(kindname);
			ClassPhoto classphoto;
			//如果就一张，设为封面，根据kindid获得该相册中照片数目，如果数目为0
			if(myclassService.getPhotokindIdByName(kindname).getClassphotos().size()==0){
				classphoto=new ClassPhoto(photoname,pubtime,user.getUsername(),pk,1,url);}
		
			else{
				 classphoto=new ClassPhoto(photoname,pubtime,user.getUsername(),pk,0,url);
				 }
			
			myclassService.saveOrUpdate(classphoto);
			
			return "showclassphotohomepage";
		}
		return "success";
	}

	// 下载班级通讯录
	public String fileDownloadExcelUser() {
		String classname = (String) request.getSession().getAttribute(
				"classname");
		inputstream = userService.downExcelUser(classname);
		return "succ";
	}
}