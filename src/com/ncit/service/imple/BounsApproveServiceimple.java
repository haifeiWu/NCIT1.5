package com.ncit.service.imple;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.BounsApprove;
import com.ncit.service.BounsApproveService;

/**
 * 申请数据的接口的实现
 * ClassName: BounsApproveServiceimple 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月24日
 */
@Service
@Transactional
public class BounsApproveServiceimple extends DaoSupportImple<BounsApprove> implements BounsApproveService {

	@Override
	public void insertNoaApproveData(List<BounsApprove> list) {
		
		
		for(int i=0; i<list.size(); i++){
			
			getSession().save(list.get(i));//?
			
			if(i%20==0){//每50条数据进行一次插入
				getSession().flush();// 只是将Hibernate缓存中的数据提交到数据库，保持与数据库数据的同步
				getSession().clear();// 清除内部缓存的全部数据，及时释放出占用的内存
			}
		}
	}
	
}






