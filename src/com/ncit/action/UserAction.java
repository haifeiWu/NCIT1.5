package com.ncit.action;


import com.ncit.base.BaseAction;
import com.ncit.entity.User;

public class UserAction extends BaseAction<User> {
	public String login(){
		System.out.println("-------------------------->UserAction");
		//查找数据库
		User user = userService.findByLoginNameAndPassword(model.getUserAccount(),model.getUserPwd());
		if(user == null){
			addFieldError("loginError", "用户名或密码不正确！");
			return "loginError";
		}else{//登陆成功
			request.getSession().setAttribute("user", user);
			return "login";
		}
	}

}
