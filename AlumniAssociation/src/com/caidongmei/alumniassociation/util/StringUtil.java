package com.caidongmei.alumniassociation.util;

import javax.servlet.http.HttpServletRequest;


public class StringUtil {
	public static String getURL(HttpServletRequest req){
		String requestURL = req.getRequestURI();
		String queryString = req.getQueryString();//获取所有参数
		String url = requestURL + "?" + filterQueryString(queryString);//过滤指定参数
		
		if(!url.endsWith("?"))
			url += "&"; 
		return url;
	}
	public static String filterQueryString(String queryString){
		if(queryString == null)
			return "";
		queryString = queryString.replaceAll("[^&]*sort=[^&]*", "")
					.replaceAll("[^&]*order=[^&]*", "")
					.replaceAll("[^&]*action=[^&]*", "")
					.replaceAll("&{2,}", "&")
					.replaceAll("^&", "")
					.replaceAll("&s", "");
		return queryString;
	}
	public static boolean isNull(String name) {
//		if(name == null)
//			return false;
//		return true;
		return name == null||name.trim().length()==0;
	}
}
