package com.ncit.entity;

import java.util.Date;

public class ProjectBounsExtend {
	
	private int id;//id序号
	private String financeId;//财务id
//	private Department department;//部门
	private String projectName;//项目名称
	private double fundSendDown;//奖金发放下限
	private double fundSendTotal;//奖金发放金额
	private Date fundSendDate;//奖金发放日期
	private String note;//备注
	
	
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getFundSendDown() {
		return fundSendDown;
	}
	public void setFundSendDown(double fundSendDown) {
		this.fundSendDown = fundSendDown;
	}
	public double getFundSendTotal() {
		return fundSendTotal;
	}
	public void setFundSendTotal(double fundSendTotal) {
		this.fundSendTotal = fundSendTotal;
	}
	public Date getFundSendDate() {
		return fundSendDate;
	}
	public void setFundSendDate(Date fundSendDate) {
		this.fundSendDate = fundSendDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
