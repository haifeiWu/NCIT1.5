package com.ncit.service.imple;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.base.DaoSupportImple;
import com.ncit.entity.BounsStats;
import com.ncit.service.BounsStatsService;

@Service
@Transactional
public class BounsStatsServiceImple extends DaoSupportImple<BounsStats> implements BounsStatsService {

	public void initBounsStatsValue(List<BounsStats> statsList) {
		
	}

}
