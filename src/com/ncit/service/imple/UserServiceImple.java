package com.ncit.service.imple;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.User;
import com.ncit.service.UserService;

@Service
@Transactional
public class UserServiceImple extends DaoSupportImple<User> implements UserService{

	@Override
	public User findByLoginNameAndPassword(String userAccount, String userPwd) {
		return (User) getSession().createQuery(
				"FROM User u WHERE u.userAccount=? AND u.userPwd=?")
				.setParameter(0, userAccount)
				.setParameter(1, userPwd)
				.uniqueResult();
	}

}
