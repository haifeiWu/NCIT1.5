package com.ncit.service;

import java.util.List;

import com.ncit.base.DaoSupport;
import com.ncit.entity.ProjectBounsExtend;

public interface ProjectBounsExtendService extends DaoSupport<ProjectBounsExtend> {

	void initBounsExtendValue(List<ProjectBounsExtend> extendList);

}
