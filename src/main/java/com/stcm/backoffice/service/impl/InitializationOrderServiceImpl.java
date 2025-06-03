package com.stcm.backoffice.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stcm.backoffice.service.InitializationOrderService;
import com.stcm.backoffice.entity.OpeInitializationOrder;
import com.stcm.backoffice.repository.OpeInitializationOrderRepository;

@Service
public class InitializationOrderServiceImpl implements InitializationOrderService {

	@Autowired
	private OpeInitializationOrderRepository opeInitializationOrderRepository;

	@Override
	public List<OpeInitializationOrder> findFilterInitializationOrder(String code, Boolean open, Timestamp from,
			Timestamp to, String equipmentCode) {
		return opeInitializationOrderRepository.findFilter(code, open, from, to, equipmentCode);
	}

	@Override
	public OpeInitializationOrder findByCodeInitializationOrder(String code) {
		return opeInitializationOrderRepository.findByCode(code);
	}

	@Override
	public int updateInitializationOrder(long id, int processed_cards, String updated_at, int accepted_cards,
			int declined_cards, String init_task) {
		return opeInitializationOrderRepository.update(id, processed_cards, updated_at, accepted_cards, declined_cards,
				init_task);
	}

	@Override
	public OpeInitializationOrder insertInitializationOrder(OpeInitializationOrder order) {

		return opeInitializationOrderRepository.save(order);
	}
	
	@Override
	public OpeInitializationOrder findLastInitializationOrder() {
		return opeInitializationOrderRepository.findLastId();
	}

}