package com.ncit.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ncit.entity.Right;
import com.ncit.service.RightService;


public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		//获取Service对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		RightService rightService = (RightService) ac.getBean("rightServiceImple");
		
		//获取权限数据topRightList
		List<Right> topRightList = rightService.findAll();
		sce.getServletContext().setAttribute("topRightList", topRightList);
		System.out.println("------------> 已准备数据topRightList <------------");
		
		//准备所有的权限数据
		Collection<String> allRightUrls = rightService.getAllRightUrls();
		sce.getServletContext().setAttribute("allRightUrls", allRightUrls);
		System.out.println("------------> 已准备数据allRightUrls <------------");
	}

}
