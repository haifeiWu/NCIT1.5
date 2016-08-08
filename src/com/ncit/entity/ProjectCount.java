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
	private double countMoney;//计提额
	private double amountPaid;//支出金额
	private String alert;//警告信息
	
	
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
	public double getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(double countMoney) {
		this.countMoney = countMoney;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	@Override
	public String toString() {
		return this.financeId+" "+this.projectName+" "+this.countMoney+" "+this.amountPaid+" "+this.alert;
	}
}
