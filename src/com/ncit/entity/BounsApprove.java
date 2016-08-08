package com.ncit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖金申请管理表
 * ClassName: BounsApprove 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月19日
 */
public class BounsApprove implements Serializable{
	
	//录入数据
	private int id;
	private String financeId;//财务ID
	private Department department;//所在部门
	private String projectName;//项目名称
	private String pmId;//PM员工ID
	private String applyId;
	private double BPPersonMonth;//BP人月
	private double memberPersonMonth;//社员人月	
	private double workPersonMonth;//连携人月
	private String applyDuration;//申请期间
	private Date approveDate;//审批日期
	private Date applyDate;//申请日期
	
	private double quitPersonMonth;
	
	//无需录入
	private double projectPersonMonth;//项目人月        *
	private double BPRate;//BP率	     BP人月/项目人月
	private double bonusMember;//社员奖金
	private double centerFund;//中心共通经费
	private double bounsWork;//连携奖金
	private double bounsMemberWork;//奖金（社员+连携）
	private double bounsTotal;//奖金总额
	private String note;
	
	//总则
	private double ratioUp;//项目经费比例上限
	private double fundUp; //项目经费上限
	private double ratioBounsDown;//项目奖金比例下限
	private double bounsDown;//项目奖金下限
	private double recommendRatio;//项目奖金推荐比例
	private double recommendFund;//项目经费推荐金额
	
	//细则
	private double bounsQuit;//离职奖金
	private double centerBouns;//中心奖金
	private double baseDepartDouns;//本部项目奖金
	private double departmentBouns;//部门项目奖金
	private double pmBouns;//pm项目奖金
	private float income;//（PM，部门，本部，中心）收入
	
	
	public double getBounsQuit() {
		return bounsQuit;
	}
	public void setBounsQuit(double bounsQuit) {
		this.bounsQuit = bounsQuit;
	}
	public double getBaseDepartDouns() {
		return baseDepartDouns;
	}
	public void setBaseDepartDouns(double baseDepartDouns) {
		this.baseDepartDouns = baseDepartDouns;
	}
	public double getDepartmentBouns() {
		return departmentBouns;
	}
	public void setDepartmentBouns(double departmentBouns) {
		this.departmentBouns = departmentBouns;
	}
	public double getPmBouns() {
		return pmBouns;
	}
	public void setPmBouns(double pmBouns) {
		this.pmBouns = pmBouns;
	}
	public void setPmBouns(float pmBouns) {
		this.pmBouns = pmBouns;
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
	public void setMemberPersonMonth(float memberPersonMonth) {
		this.memberPersonMonth = memberPersonMonth;
	}
	public double getBPRate() {
		return BPRate;
	}
	public void setBPRate(double bPRate) {
		BPRate = bPRate;
	}
	public void setBonusMember(float bonusMember) {
		this.bonusMember = bonusMember;
	}
	public void setCenterFund(float centerFund) {
		this.centerFund = centerFund;
	}
	public void setWorkPersonMonth(float workPersonMonth) {
		this.workPersonMonth = workPersonMonth;
	}
	public void setBounsWork(float bounsWork) {
		this.bounsWork = bounsWork;
	}
	public void setBounsMemberWork(float bounsMemberWork) {
		this.bounsMemberWork = bounsMemberWork;
	}
	public void setBounsTotal(float bounsTotal) {
		this.bounsTotal = bounsTotal;
	}
	public String getApplyDuration() {
		return applyDuration;
	}
	public void setApplyDuration(String applyDuration) {
		this.applyDuration = applyDuration;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public double getRatioUp() {
		return ratioUp;
	}
	public void setRatioUp(double ratioUp) {
		this.ratioUp = ratioUp;
	}
	public double getRecommendRatio() {
		return recommendRatio;
	}
	public void setRecommendRatio(double recommendRatio) {
		this.recommendRatio = recommendRatio;
	}
	public float getIncome() {
		return income;
	}
	public double getRecommendFund() {
		return recommendFund;
	}
	public void setRecommendFund(double recommendFund) {
		this.recommendFund = recommendFund;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPmId() {
		return pmId;
	}
	public void setPmId(String pmId) {
		this.pmId = pmId;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public double getRatioBounsDown() {
		return ratioBounsDown;
	}
	public void setRatioBounsDown(double ratioBounsDown) {
		this.ratioBounsDown = ratioBounsDown;
	}
	public double getFundUp() {
		return fundUp;
	}
	public void setFundUp(double fundUp) {
		this.fundUp = fundUp;
	}
	public double getBounsDown() {
		return bounsDown;
	}
	public void setBounsDown(double bounsDown) {
		this.bounsDown = bounsDown;
	}
	public double getCenterBouns() {
		return centerBouns;
	}
	public void setCenterBouns(double centerBouns) {
		this.centerBouns = centerBouns;
	}
	public double getBPPersonMonth() {
		return BPPersonMonth;
	}
	public void setBPPersonMonth(double bPPersonMonth) {
		BPPersonMonth = bPPersonMonth;
	}
	public double getMemberPersonMonth() {
		return memberPersonMonth;
	}
	public void setMemberPersonMonth(double memberPersonMonth) {
		this.memberPersonMonth = memberPersonMonth;
	}
	public double getWorkPersonMonth() {
		return workPersonMonth;
	}
	public void setWorkPersonMonth(double workPersonMonth) {
		this.workPersonMonth = workPersonMonth;
	}
	public double getProjectPersonMonth() {
		return projectPersonMonth;
	}
	public void setProjectPersonMonth(double projectPersonMonth) {
		this.projectPersonMonth = projectPersonMonth;
	}
	public double getBonusMember() {
		return bonusMember;
	}
	public void setBonusMember(double bonusMember) {
		this.bonusMember = bonusMember;
	}
	public double getCenterFund() {
		return centerFund;
	}
	public void setCenterFund(double centerFund) {
		this.centerFund = centerFund;
	}
	public double getBounsWork() {
		return bounsWork;
	}
	public void setBounsWork(double bounsWork) {
		this.bounsWork = bounsWork;
	}
	public double getBounsMemberWork() {
		return bounsMemberWork;
	}
	public void setBounsMemberWork(double bounsMemberWork) {
		this.bounsMemberWork = bounsMemberWork;
	}
	public double getBounsTotal() {
		return bounsTotal;
	}
	public void setBounsTotal(double bounsTotal) {
		this.bounsTotal = bounsTotal;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getQuitPersonMonth() {
		return quitPersonMonth;
	}
	public void setQuitPersonMonth(double quitPersonMonth) {
		this.quitPersonMonth = quitPersonMonth;
	}
	
	@Override
	public String toString() {
		return this.financeId+" "+this.projectName+" "+this.centerFund;
	}
}
