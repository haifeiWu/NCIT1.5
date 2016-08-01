package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsStats;

public interface BounsStatsService extends DaoSupport<BounsStats>{

	void initBounsStatsValue(List<BounsStats> statsList);

}
