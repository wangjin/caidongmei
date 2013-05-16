package com.caidongmei.alumniassociation.service;

import java.io.File;
import java.util.List;

import com.caidongmei.alumniassociation.dao.FileDAO;
import com.caidongmei.alumniassociation.pojo.User;

public class FileService {
    
	public static List<User> uploadExcel(File file) {
		return FileDAO.uploadExcel(file);
	}
	
}
