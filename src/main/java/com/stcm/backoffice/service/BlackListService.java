package com.stcm.backoffice.service;

import java.util.List;

import com.stcm.backoffice.entity.OpeBlackListCard;
import com.stcm.backoffice.entity.OpeBlackListSam;
import com.stcm.backoffice.entity.OpeCardHandler;

public interface BlackListService {
	
	List<OpeBlackListCard> retrieveBlackList();
	
	OpeBlackListCard insertBlackListCard(OpeBlackListCard opeListCard);
	
	OpeBlackListSam retrieveBlackListByUidSam(String uid_sam);
	
	OpeCardHandler insertCardHanlder(OpeCardHandler opeCard);
	
	int updateCardHandlerByUid(String uid);

}
