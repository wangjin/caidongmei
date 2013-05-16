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
        // ��ȡsession
        Map<String, Object> session = context.getSession();
        Object user = session.get("user");
        // �û���δ��½
        if (user == null) {
            // ��ȡHttpServletRequest����
            HttpServletRequest req = ServletActionContext.getRequest();
            // ��ȡ������ĵ�ַ�������ַ����application name������subString������ȥ��application name
            String path = req.getRequestURI().substring(10);
            // ��������еĲ���
            String queryString = req.getQueryString();
            // Ԥ����ָ��
            if (queryString == null) {
                queryString = "";
            }
            // ƴ�յõ���½֮ǰ�ĵ�ַ
            String realPath = path + "?" + queryString;
            // ����session���������
            session.put("prePage", realPath);
            return "login";
        }
        // �û��Ѿ���½������
        return invocation.invoke();
    }
 
}
