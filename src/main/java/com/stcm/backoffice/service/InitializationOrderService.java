package com.stcm.backoffice.service;

import java.sql.Timestamp;
import java.util.List;

import com.stcm.backoffice.entity.OpeInitializationOrder;

public interface InitializationOrderService {
	
	List<OpeInitializationOrder> findFilterInitializationOrder(String code, Boolean open, Timestamp from, Timestamp to, String equipmentCode);
	OpeInitializationOrder findByCodeInitializationOrder(String code);
	int updateInitializationOrder(long id, int processed_cards, String updated_at, int accepted_cards, int declined_cards, String init_task);
	OpeInitializationOrder insertInitializationOrder(OpeInitializationOrder order);
	OpeInitializationOrder findLastInitializationOrder();
}
