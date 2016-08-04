package com.ncit.base;

import java.io.File;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ncit.service.BounsApproveService;
import com.ncit.service.BounsSendService;
import com.ncit.service.BounsStatsService;
import com.ncit.service.BounsUseService;
import com.ncit.service.ProjectBounsExtendService;
import com.ncit.service.RightService;
import com.ncit.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 基础Action类
 * @author wuhaifei
 * @2016年7月17日
 * @BaseAction
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {

	protected T model;
	
	protected String result;
	
	protected File uploadfile;
	protected String uploadfileContentType;
	protected String uploadfileFileName;
	
	protected String userAccount;
	protected String usersession;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);//将异常抛出
		} 
	}
	
	@Override
	public T getModel() {
		return model;
	}
	
	
	// =============== Service实例的声明 ==================
	@Resource
	protected UserService userService;//用户
	@Resource
	protected RightService rightService;//权限
	@Resource
	protected BounsApproveService bounsApproveService;//项目奖金申请
	@Resource
	protected BounsUseService bounsUseService;//项目奖金报销
	@Resource
	protected ProjectBounsExtendService projectBounsExtendService;
	@Resource
	protected BounsStatsService bounsStatsService;
	@Resource
	protected BounsSendService bounsSendService;//项目奖金发放
	
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
}
