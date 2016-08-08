package com.ncit.entity;

/**
 * 项目计提信息实体类
 * @author wuhaifei
 *
 * @date 2016年8月8日
 */
public class ProjectCount {
	private String financeId;//财务ID
	private String projectName;//项目名称
	private String countMoney;//计提额
	
	
	public String getFinanceId() {
		return financeId;
	}
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(String countMoney) {
		this.countMoney = countMoney;
	}
}
