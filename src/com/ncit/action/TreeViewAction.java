package com.ncit.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ncit.base.BaseAction;
import com.ncit.entity.Right;
import com.ncit.entity.User;
import com.ncit.util.MySessionContext;
import com.ncit.util.SimplePropertyFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TreeViewAction extends BaseAction<Right> implements ServletContextAware {
	
	private ServletContext servletContext;
	
	public String treeListView(){//加载目录树
		System.out.println("-------------------------->treeListView");
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		SimplePropertyFilter filter = new SimplePropertyFilter();
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null){
			map.clear();//清空map
			map.put("seccuss","loginError");
			result = JSON.toJSONString(map);
		}else{
			map.clear();//清空map
			//清除session
			request.getSession().removeAttribute("user");
			//更新session
			request.getSession().setAttribute("user", user);
			//加载application域中的权限
			List<Right> rightList = (List<Right>) servletContext.getAttribute("topRightList");
			
			map.put("success", "welcome");
			result = JSON.toJSONString(rightList,filter);
			map.put("data", result);
			result = JSON.toJSONString(map);
			
		}
		return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
