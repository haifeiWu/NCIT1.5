package com.ncit.service;

import java.util.Collection;
import java.util.List;



import com.ncit.base.DaoSupport;
import com.ncit.entity.Right;

/**
 * ClassName: RightService 
 * @Description: 权限管理的service层接口
 * @author wuhaifei
 * @date 2016年7月20日
 */
public interface RightService extends DaoSupport<Right>{
	/**
	 * 查询所有顶级的权限
	 * 
	 * @return
	 */
	List<Right> findTopList();

	/**
	 * 查询所有权限对应的URL集合（不重复）
	 * @return
	 */
	Collection<String> getAllRightUrls();

	List<Right> getAllRight();
}
