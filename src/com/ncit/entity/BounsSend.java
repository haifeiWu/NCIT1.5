package com.ncit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖金发放
 * ClassName: BoundsSend 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月19日
 */
public class BounsSend implements Serializable{
	
	private int id;//id序号
	
	private String financeId;//财务id
	private Department department;//部门
	private String employeeId;//员工Id
	private String employeeName;//员工姓名
	private String projectName;//项目名称
	private float fundSendDown;//奖金发放下限
	private String applyDuration;//申请期间
	private String note;//备注
	private float fundSend;//奖金发放金额
	private Date applyDate;//申请日期
	private Date fundSendDate;//奖金发放日期
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getApplyDuration() {
		return applyDuration;
	}
	public void setApplyDuration(String applyDuration) {
		this.applyDuration = applyDuration;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
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
	public float getFundSendDown() {
		return fundSendDown;
	}
	public void setFundSendDown(float fundSendDown) {
		this.fundSendDown = fundSendDown;
	}
	public float getFundSend() {
		return fundSend;
	}
	public void setFundSend(float fundSend) {
		this.fundSend = fundSend;
	}
	public Date getFundSendDate() {
		return fundSendDate;
	}
	public void setFundSendDate(Date fundSendDate) {
		this.fundSendDate = fundSendDate;
	}
}
