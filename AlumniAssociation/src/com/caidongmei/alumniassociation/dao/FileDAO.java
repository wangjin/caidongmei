package com.caidongmei.alumniassociation.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.caidongmei.alumniassociation.pojo.Role;
import com.caidongmei.alumniassociation.pojo.User;
import com.caidongmei.alumniassociation.util.ExcelUploadUtil;

public class FileDAO {

	public static List<User> uploadExcel(File file) {
		String cellValue = null;
		List<User> userList = new ArrayList<User>();
		try {
			HSSFWorkbook excel = ExcelUploadUtil.getExcel(file);// ʹ�÷�װ�õķ���ȡ���ϴ���excel����
			for (int k = 0; k <= excel.getNumberOfSheets() - 1; k++) {
				HSSFSheet sheet = excel.getSheetAt(k);// ȡ������excel���ĵ�kҳ
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					HSSFRow row = sheet.getRow(i);
					User user = new User();
					for (int j = 0; j <= 16; j++) {
						HSSFCell cell = row.getCell(j);
						cellValue = ExcelUploadUtil.getCellValue(cell);// ��õ�Ԫ���ֵ
						//System.out.println(cellValue);
						if (cellValue == null) {
							continue;
						}
						switch (j)
						{
						case 0:
							user.setUserid(Integer.parseInt(cellValue));
							break;
						case 1:
							user.setUsername(cellValue);
							break;
						case 2:
							user.setPassword(cellValue);
							break;
						case 3:
							user.setGender(cellValue);
							break;
						case 4:
							user.setMajor(cellValue);
							break;
						
						case 5:
							user.setCellphone(cellValue);
							break;
						case 6:
							user.setContactaddress(cellValue);
							break;
						case 7:
							user.setEmail(cellValue);
							break;
						case 8:
							user.setProvince(cellValue);
							break;
						case 9:
							user.setCity(cellValue);
							break;
						case 10:
							user.setXuehao(cellValue);
							break;
						case 11:
							user.setGraduation(cellValue);
							break;
						case 12:
							user.setIdentitycard(cellValue);
							break;
						case 13:
							user.setAge(Integer.parseInt(cellValue));
							break;
						case 14:
							user.setState(0);//Ĭ��Ϊλ���
							break;
						case 15:
							user.setRemark(cellValue);
							break;
						case 16:
							user.setClassone(null);
							Role role=new Role();
							role.setRoleid(3);//Ĭ��Ϊ��ͨѧ��
							user.setRole(role);
							break;
						}
					}
						userList.add(user);
				}
			
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
}
