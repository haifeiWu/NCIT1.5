package com.ncit.entity;

import java.io.Serializable;

/**
 * 奖金统计
 * ClassName: BounsStats 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月19日
 */
public class BounsStats implements Serializable{
	private int id;
	private String financeId;//财务ID
	private String department;//部门
	private String projectName;//项目名称
	private double bounsTotal;//经费总额（奖金总额）
	private double bounsSendTotal;//奖金发放总额
	private double bounsUseTotal;//奖金使用（报销数据）
	private double bounsUsedTotal;//用于奖金发放与报销的总额
	private double balance;//余额
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFinanceId() {
		return financeId;
	}
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getBounsTotal() {
		return bounsTotal;
	}
	public void setBounsTotal(double bounsTotal) {
		this.bounsTotal = bounsTotal;
	}
	public double getBounsSendTotal() {
		return bounsSendTotal;
	}
	public void setBounsSendTotal(double bounsSendTotal) {
		this.bounsSendTotal = bounsSendTotal;
	}
	public double getBounsUseTotal() {
		return bounsUseTotal;
	}
	public void setBounsUseTotal(double bounsUseTotal) {
		this.bounsUseTotal = bounsUseTotal;
	}
	public double getBounsUsedTotal() {
		return bounsUsedTotal;
	}
	public void setBounsUsedTotal(double bounsUsedTotal) {
		this.bounsUsedTotal = bounsUsedTotal;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
