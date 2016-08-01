package com.ncit.util;

import org.apache.struts2.ServletActionContext;

import com.ncit.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录权限检查
 * ClassName: CheckRightInterceptor 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月18日
 */
public class CheckRightInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------------------>之前");
		
		User user = (User) ServletActionContext.getContext().getSession().get("user");//从session域中获取user
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String rightUrl = namespace + actionName; // 对应的权限URL
		
		System.out.println(user);
		System.out.println("对应的权限URL:"+rightUrl);
		
		if(user == null){
			if(rightUrl.startsWith("/Login")){
				return invocation.invoke();//如果去登陆,放行去登录
			}else{
				return "loginError";//如果不是去登录就转跳到登录界面
			}
		}else{
			if (user.hasRightByUrl(rightUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();
			} else {
				// 如果没有权限，就转到提示页面
				return "noRightError";
			}
		}
	}

}
