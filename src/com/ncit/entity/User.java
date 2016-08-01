package com.ncit.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import com.opensymphony.xwork2.ActionContext;


/**
 * 用户类
 * @author wuhaifei
 * @2016年7月17日
 * @User
 */
public class User implements Serializable{
	private int userId;//用户id
	private String userName;//用户姓名
	private String userAccount;//账号
	private String userPwd;//登录密码
	private String userEmail;//用户邮箱
	private String userPhoneNumber;//用户手机号
	private String userDescription;//用户描述
	
	private Department department;//所在部门
	
	private Set<Role> roles = new HashSet<Role>();//角色
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * 判断用户权限
	 * @param rightUrl
	 * @return boolean  
	 * @author wuhaifei
	 * @date 2016年7月20日
	 */
	public boolean hasRightByUrl(String rightUrl) {
		if(isAdmin()){//判断是否为超级管理员
			return true;
		}
		//去掉后面的参数
		int pos = rightUrl.indexOf("?");
		if (pos > -1) {
			rightUrl = rightUrl.substring(0, pos);
		}
		// 如果本URL不需要控制，则登录用户就可以使用
		Collection<String> allRightUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allRightUrls");
		if (!allRightUrls.contains(rightUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (Role role : roles) {
				for (Right right : role.getRight()) {
					if (rightUrl.equals(right.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}
	
	/**
	 * 判断超级管理员权限
	 * @param    
	 * @return boolean
	 * @author wuhaifei
	 * @date 2016年7月20日
	 */
	private boolean isAdmin() {
		return "admin".equals(this.userAccount);
	}

}
