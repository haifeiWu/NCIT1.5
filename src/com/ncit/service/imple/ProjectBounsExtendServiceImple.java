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
		
	}

}
