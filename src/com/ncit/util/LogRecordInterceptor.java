package com.ncit.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ncit.action.UserAction;
import com.ncit.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;

/**
 * 日志记录拦截器
 * 通过访问的url来判断用户操作
 * ClassName: LogRecordInterceptor 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月26日
 */
public class LogRecordInterceptor extends AbstractInterceptor {
	
	 private String logName;  
	 private String logContent;  
	 
//	 protected Logger log = Logger.getLogger(); 
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("--------------->日志拦截器");
		
		
		Map session = invocation.getInvocationContext().getSession();  
        Object action = invocation.getAction();  
        String method = invocation.getProxy().getMethod(); 
        if(StringUtils.isBlank(method)) 
        	method = "method"; 
        User sysUser = (User)session.get("user");  
        String userName = "";  
        if(sysUser!=null) 
        	userName = sysUser.getUserName();
        String currentTime = TimeHelper.getCurrentTime();  
        String logContentHead = "用户"+userName+currentTime;
        
        invocation.invoke();//执行拦截action
        
        if (action instanceof UserAction) {  
        	 if(method.equals("login")){  
        		 logName = "登录";
        		 logContent = logContentHead +"登录";
        		 System.out.println("------->"+logContent);
        		 addSysLog(logName,logContent);  
        	 }
        	 
        	 if(method.equals("logout")){  
        		 logName = "注销";
        		 logContent = logContentHead +"注销";
        		 System.out.println("------->"+logContent);
        		 addSysLog(logName,logContent); 
        	 }
        }
//        if (action instanceof TreeViewAction) {
//        	if(method.equals("treeListView")){
//        		logName = "treeListView登录";
//        		logContent = logContentHead +"treeListView登录";
//        		System.out.println("------->"+logContent);
//	       		addSysLog(logName,logContent); 
//        	}
//        }
//        if (action instanceof ImportApproveAction) {
//        	if(method.equals("approve")){
//        		logName = "申请数据导入";
//        		logContent = logContentHead +"申请数据导入";
////	       		logContent = logContentHead +"申请数据导入"+
////        		((String[])(invocation.getStack().findValue("flag_id"))).length+"条申请数据";
//	       		System.out.println("------->"+logContent);
//	       		addSysLog(logName,logContent); 
//        	}
//        }
		//获取当前登录用户
//		User user = (User) ActionContext.getContext().getSession().get("user");
//		String nameSpace = invocation.getProxy().getNamespace();
//		String actionName = invocation.getProxy().getActionName();
//		
//		System.out.println("--------->actionName"+actionName);
		
		return null;
	}

	/**
	 * 插入系统日志
	 * @param @param logName
	 * @param @param logContent   
	 * @author wuhaifei
	 * @date 2016年7月26日
	 */
	private void addSysLog(String logName, String logContent) {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		LogRecordService logRecordService = (LogRecordService) ac.getBean("LogRecordService");
//		
//		LogRecorder log = new LogRecorder();
//		log.setLogName(logName);
//		log.setOpContent(logContent);
//		log.setOpTime(TimeHelper.getCurrentTime());
//		//保存到数据库
//		logRecordService.save(log);
	}

}




