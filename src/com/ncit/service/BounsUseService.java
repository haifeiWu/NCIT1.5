package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsUse;

public interface BounsUseService extends DaoSupport<BounsUse> {

	void initBounsUseValue(List<BounsUse> useList);

}
