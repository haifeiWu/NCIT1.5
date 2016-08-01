package com.ncit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupport;
import com.ncit.entity.User;

/**
 * user的service层
 * ClassName: UserService 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月17日
 */
public interface UserService extends DaoSupport<User>{
	/**
	 * 根据登录名与密码查询用户
	 * 
	 * @param loginName
	 * @param password
	 *            明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String userAccount, String userPwd);
}
