package com.stcm.backoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stcm.backoffice.entity.OpeBlackListCard;
import com.stcm.backoffice.entity.OpeBlackListSam;
import com.stcm.backoffice.entity.OpeCardHandler;
import com.stcm.backoffice.repository.OpeBlackListCardRepository;
import com.stcm.backoffice.repository.OpeBlackListSamRepository;
import com.stcm.backoffice.repository.OpeCardHandlerRepository;
import com.stcm.backoffice.service.BlackListService;

@Service
public class BlackListServiceImpl implements BlackListService {
	
	/*
	 * 
	 * Black List
	 * 
	 */
	@Autowired
	private OpeBlackListCardRepository opeBlackListCardRepository;

	@Override
	public List<OpeBlackListCard> retrieveBlackList() {
		return opeBlackListCardRepository.retrieveBlackList();
	}
	
	
	@Override
	public OpeBlackListCard insertBlackListCard(OpeBlackListCard opeListCard) {
		return opeBlackListCardRepository.saveAndFlush(opeListCard);
	}
	
	
	@Autowired
	private OpeBlackListSamRepository opeBlackListSamRepository;
	
	@Override
	public OpeBlackListSam retrieveBlackListByUidSam(String uid_sam) {
		return opeBlackListSamRepository.retrieveBlackListByUidSam(uid_sam);
	}
	
	
	/*
	 * 
	 * OpeCardHandler
	 * 
	 */
	
	@Autowired
	private OpeCardHandlerRepository opeCardHandlerRepository; 
	
	@Override
	public OpeCardHandler insertCardHanlder(OpeCardHandler opeCard) {
		return opeCardHandlerRepository.saveAndFlush(opeCard);
	}
	
	@Override
	public int updateCardHandlerByUid(String uid) {
		return opeCardHandlerRepository.updateCardHandlerByUid(uid);
	}

}
