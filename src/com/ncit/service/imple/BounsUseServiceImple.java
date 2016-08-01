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
		
	}

}
