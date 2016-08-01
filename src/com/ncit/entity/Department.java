package com.ncit.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门
 * ClassName: Department 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月24日
 */
public class Department implements Serializable{
	private int departmentId;
	private Set<User> users = new HashSet<User>();
//	private Set<BounsApprove> bouns = new HashSet<BounsApprove>();
	private Department parent;
	private Set<Department> children = new HashSet<Department>();

	private String departmentName;
	
	private String description;

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
