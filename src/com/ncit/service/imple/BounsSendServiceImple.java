package com.ncit.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.BounsSend;
import com.ncit.service.BounsSendService;
import com.ncit.util.ConstantField;

/**
 * 
 * ClassName: BounsSendServiceImple 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月25日
 */
@Service
@Transactional
public class BounsSendServiceImple extends DaoSupportImple<BounsSend> implements
		BounsSendService {

	@Override
	public void insertBounsSendValue(List<BounsSend> list) {
		for(int i=0; i<list.size(); i++){
			
			getSession().save(list.get(i));
			
			if(i%20 == 0){
				getSession().flush();
				getSession().clear();
			}
		}
	}

	@Override
	public List<BounsSend> findProjectFinanceId(String center) {
		List<BounsSend> list = new ArrayList<BounsSend>();
		char c = center.charAt(0);
		switch (c) {
		case ConstantField.BEIJING:
			list = getSession().createQuery("select DISTINCT b.financeId from BounsSend as b where "
					+ "b.fundSend=0 and b.financeId like :name").setParameter("name","%B%").list();
			break;
		case ConstantField.TIANJIN:
			list = getSession().createQuery("select DISTINCT b.financeId from BounsSend as b where "
					+ "b.fundSend=0 and b.financeId like :name").setParameter("name","%T%").list();
			break;
		case ConstantField.WUXI:
			list = getSession().createQuery("select DISTINCT b.financeId from BounsSend as b where "
					+ "b.fundSend=0 and b.financeId like :name").setParameter("name","%W%").list();
			break;
		case ConstantField.XIAN:
			list = getSession().createQuery("select DISTINCT b.financeId from BounsSend as b where "
					+ "b.fundSend=0 and b.financeId like :name").setParameter("name","%X").list();
			break;
		case ConstantField.CHANGCHUN:
			list = getSession().createQuery("select DISTINCT b.financeId from BounsSend as b where "
					+ "b.fundSend=0 and b.financeId like :name").setParameter("name","%C%").list();
			break;
		default:
			break;
		}
		return list;
	}

	@Override
	public List<BounsSend> findEmployeeByFinanceId(String financeId) {
		List<BounsSend> list = new ArrayList<BounsSend>();
		list = getSession().createQuery("select b.employeeId,b.employeeName,b.fundSend from BounsSend b "
				+ "where b.financeId=:financeId").setParameter("financeId", financeId).list();
		return list;
	}
	
}
