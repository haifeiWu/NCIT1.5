package com.ncit.service.imple;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.BounsUse;
import com.ncit.service.BounsUseService;

@Service
@Transactional
public class BounsUseServiceImple extends DaoSupportImple<BounsUse> implements BounsUseService {

	@Override
	public void initBounsUseValue(List<BounsUse> useList) {
		
		for(int i=0; i<useList.size(); i++){
			getSession().save(useList.get(i));
			
			if(i%20==0){//每50条数据进行一次插入
				getSession().flush();// 只是将Hibernate缓存中的数据提交到数据库，保持与数据库数据的同步
				getSession().clear();// 清除内部缓存的全部数据，及时释放出占用的内存
			}
		}
	}

	@Override
	public void updateBounsUseInfor(List<BounsUse> updateList) {
		
	}

}
