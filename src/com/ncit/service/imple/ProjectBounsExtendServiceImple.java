package com.ncit.service.imple;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.ProjectBounsExtend;
import com.ncit.service.ProjectBounsExtendService;

@Service
@Transactional
public class ProjectBounsExtendServiceImple extends DaoSupportImple<ProjectBounsExtend> implements ProjectBounsExtendService {

	@Override
	public void initBounsExtendValue(List<ProjectBounsExtend> extendList) {
		//插入该表时应注意财务Id相同时应该将财务id相同的信息合并
		for(int i=0; i<extendList.size(); i++){
			getSession().save(extendList.get(i));
			
			if(i%20==0){//每50条数据进行一次插入
				getSession().flush();// 只是将Hibernate缓存中的数据提交到数据库，保持与数据库数据的同步
				getSession().clear();// 清除内部缓存的全部数据，及时释放出占用的内存
			}
		}
		
	}

}
