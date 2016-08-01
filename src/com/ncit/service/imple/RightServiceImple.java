package com.ncit.service.imple;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.Right;
import com.ncit.service.RightService;

/**
 * ClassName: RightServiceImple 
 * @Description: 权限管理的service层代码
 * @author wuhaifei
 * @date 2016年7月20日
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class RightServiceImple extends DaoSupportImple<Right> implements RightService {

	@Override
	public List<Right> findTopList() {
		return getSession().createQuery(
				"FROM Right r where r.parent is null")
				.list();
	}

	@Override
	public Collection<String> getAllRightUrls() {
		return getSession().createQuery(
				"SELECT DISTINCT r.url FROM Right r WHERE r.url IS NOT NULL")
				.list();
	}

	@Override
	public List<Right> getAllRight() {
		return getSession().createQuery(
				"FROM Right")//DISTINCT r.rightId,r.url,r.rightName,r.parentId
				.list();
	}
}
