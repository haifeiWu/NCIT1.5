package com.ncit.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色类
 * @author wuhaifei
 * @2016年7月17日
 * @Role
 */
public class Role implements Serializable{
	private int roleId;//角色id
	private String roleName;//角色名称
	private String roleDescription;//角色描述
	
	private Set<User> users = new HashSet<User>();//用户与角色之间的关系是多对多
	
	private Set<Right> right = new HashSet<Right>();//角色与权限之间的关系是多对多

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Right> getRight() {
		return right;
	}

	public void setRight(Set<Right> right) {
		this.right = right;
	}
}
