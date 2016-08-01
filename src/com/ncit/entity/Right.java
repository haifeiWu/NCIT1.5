package com.ncit.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 权限类
 * @author wuhaifei
 * @2016年7月17日
 * @Right
 */
public class Right{
	private int rightId;//权限id
	private String url;
	private String rightName; // 权限名称
	private Set<Role> roles = new HashSet<Role>();//角色
	private Right parent; // 上级权限
	private Set<Right> children = new HashSet<Right>(); // 下级权限
	
	public Right() {
	}

	public Right(String rightName, String url, Right parent) {
		this.rightName = rightName;
		this.url = url;
		this.parent = parent;
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Right getParent() {
		return parent;
	}

	public void setParent(Right parent) {
		this.parent = parent;
	}

	public Set<Right> getChildren() {
		return children;
	}

	public void setChildren(Set<Right> children) {
		this.children = children;
	}
}
