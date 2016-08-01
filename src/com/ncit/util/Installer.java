package com.ncit.util;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ncit.entity.Right;
import com.ncit.entity.User;

@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 执行安装
	 */
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		// ==============================================================
		// 保存超级管理员用户
		User user = new User();
		user.setUserAccount("admin");
		user.setUserName("超级管理员");
		user.setUserPwd(DigestUtils.md5Hex("admin"));
		session.save(user); // 保存
		// ==============================================================
		// 保存权限数据
		Right menu, menu1, menu2, menu3, menu4, menu5;

		// --------------------
		menu = new Right("数据导入", null, null);
		menu1 = new Right("申请数据", "./jsp/import_approve.jsp", menu);
		menu2 = new Right("财务报销数据", "./jsp/import_expense.jsp", menu);
		menu3 = new Right("项目体制", "./jsp/import_organization.jsp", menu);
		menu4 = new Right("项目奖金分配", "./jsp/import_distribution.jsp", menu);
		menu5 = new Right("项目计提Check", "./jsp/import_accruedCheck.jsp", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);

		// --------------------
//		menu = new Right("奖金分配", null, null);
//		menu1 = new Right("奖金管理", "/processDefinition_list", menu);
//		session.save(menu);
//		session.save(menu1);
		
		menu = new Right("参数设置", null, null);
		menu1 = new Right("比例设置", "./jsp/ratio_set.jsp", menu);
		session.save(menu);
		session.save(menu1);
		
		menu = new Right("报表分析", null, null);
		menu1 = new Right("项目奖金信息", "./jsp/bous_information.jsp", menu);
		menu2 = new Right("奖金报警信息", "./jsp/bouns_warning.jsp", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		
		menu = new Right("系统管理", null, null);
		menu1 = new Right("岗位管理", "./jsp/station_list.jsp", menu);
		menu2 = new Right("部门管理", "./jsp/department_list.jsp", menu);
		menu3 = new Right("用户管理", "./jsp/user_list.jsp", menu);
		menu4 = new Right("系统日志", "./jsp/system_log.jsp", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
//		System.out.println("min"+Integer.MIN_VALUE);
	}
}
