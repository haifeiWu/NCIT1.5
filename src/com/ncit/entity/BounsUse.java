package com.ncit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖金使用（主要用于经费的报销）
 * ClassName: BounsUse 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月19日
 */
public class BounsUse implements Serializable{
	private int id;//id序号
	private String financeId;//财务id
	private String projectName;//项目名称
	private String evidenceId;//凭证号
	private double fundUseUp;//项目经费使用上限
	private double fundRecommend;//推荐经费使用总额
	private String expenseReason;//报销缘由  ----->excel表的摘要
	private double expenseMoney;//报销费用
	private Date expenseDate;//报销日期
	private String alert;//警告信息
	
	
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
	public double getFundUseUp() {
		return fundUseUp;
	}
	public void setFundUseUp(double fundUseUp) {
		this.fundUseUp = fundUseUp;
	}
	public double getFundRecommend() {
		return fundRecommend;
	}
	public void setFundRecommend(double fundRecommend) {
		this.fundRecommend = fundRecommend;
	}
	public String getExpenseReason() {
		return expenseReason;
	}
	public void setExpenseReason(String expenseReason) {
		this.expenseReason = expenseReason;
	}
	public double getExpenseMoney() {
		return expenseMoney;
	}
	public void setExpenseMoney(double expenseMoney) {
		this.expenseMoney = expenseMoney;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	public String getEvidenceId() {
		return evidenceId;
	}
	public void setEvidenceId(String evidenceId) {
		this.evidenceId = evidenceId;
	}
	
	@Override
	public String toString() {
		return this.evidenceId+" "+this.financeId+" "+this.projectName+" "+this.expenseMoney+""+this.expenseDate;
	}
}
