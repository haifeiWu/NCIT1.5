package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsApprove;

/**
 * 申请数据相关操作的service接口
 * ClassName: BounsApproveService 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月24日
 */
public interface BounsApproveService extends DaoSupport<BounsApprove>{

	/**
	 * 向数据库中插入Noa数据
	 * @param list
	 * @return none  
	 * @throws none
	 * @author wuhaifei
	 * @date 2016年7月24日
	 */
	void insertNoaApproveData(List<BounsApprove> list);
}
