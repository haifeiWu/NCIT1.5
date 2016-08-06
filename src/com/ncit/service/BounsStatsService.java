package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsStats;

/**
 * 接口层代码
 * @author wuhaifei
 *
 * @date 2016年8月5日
 */
public interface BounsStatsService extends DaoSupport<BounsStats>{

	/**
	 * 初始化项目奖金信息统计表
	 * @param statsList
	 */
	void initBounsStatsValue(List<BounsStats> statsList);

	/**
	 * 更新项目奖金信息
	 * @param statsList
	 */
	void updateBunstatsInfor(List<BounsStats> statsList);

}
