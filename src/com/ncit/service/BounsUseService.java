package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsUse;

public interface BounsUseService extends DaoSupport<BounsUse> {

	/**
	 * 初始化项目报销数据
	 * @param useList
	 */
	void initBounsUseValue(List<BounsUse> useList);
	
	/**
	 * 更新项目报销信息
	 * @param updateList
	 */
	void updateBounsUseInfor(List<BounsUse> updateList);

}
