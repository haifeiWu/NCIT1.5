package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.BounsSend;

public interface BounsSendService extends DaoSupport<BounsSend>{

	List<BounsSend> findProjectFinanceId(String center);


	void insertBounsSendValue(List<BounsSend> list);


	List<BounsSend> findEmployeeByFinanceId(String financeID);

}
