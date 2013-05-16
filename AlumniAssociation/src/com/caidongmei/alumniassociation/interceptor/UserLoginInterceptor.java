package com.caidongmei.alumniassociation.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserLoginInterceptor implements Interceptor {
 
    private static final long serialVersionUID = 1593745236481514166L;
 
    public void destroy() {
    }
 
    public void init() {
    }
 
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext context = invocation.getInvocationContext();
        // 获取session
        Map<String, Object> session = context.getSession();
        Object user = session.get("user");
        // 用户还未登陆
        if (user == null) {
            // 获取HttpServletRequest对象
            HttpServletRequest req = ServletActionContext.getRequest();
            // 获取此请求的地址，请求地址包含application name，进行subString操作，去除application name
            String path = req.getRequestURI().substring(10);
            // 获得请求中的参数
            String queryString = req.getQueryString();
            // 预防空指针
            if (queryString == null) {
                queryString = "";
            }
            // 拼凑得到登陆之前的地址
            String realPath = path + "?" + queryString;
            // 存入session，方便调用
            session.put("prePage", realPath);
            return "login";
        }
        // 用户已经登陆，放行
        return invocation.invoke();
    }
 
}
