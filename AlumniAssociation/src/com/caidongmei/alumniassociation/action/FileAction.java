package com.caidongmei.alumniassociation.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.service.FileService;
import com.caidongmei.alumniassociation.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction<ArryList> extends ActionSupport {

	/**
	 * @author CaiDongmei
	 */
	private static final long serialVersionUID = 1L;

	// 文件对象
	private File file;
	@Autowired
	private UserService userService;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String upload() throws Exception {
		List<User> users = FileService.uploadExcel(file);
		for (User user : users) {
			userService.insert(user);
		}
		return "upload";
	}
	
}
