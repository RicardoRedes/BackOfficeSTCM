package com.stcm.backoffice.bussines;

import java.util.List;

import com.stcm.backoffice.entity.OpeBlackListCard;
import com.stcm.backoffice.entity.request.AccessRequest;
import com.stcm.backoffice.entity.request.AccessRequest2;
import com.stcm.backoffice.service.BlackListService;

public class ApiBlackList {
	
	public static List<OpeBlackListCard> getBlackList(BlackListService blackListService) {
		List<OpeBlackListCard> blackList = blackListService.retrieveBlackList();

		if (blackList.isEmpty()) {
			return null;
		} else {
			return blackList;
		}
	}
	
	public static String getBlackListXml(BlackListService blackListService) {
		
		List<OpeBlackListCard> blackList = blackListService.retrieveBlackList();

		String xml = new String();
		xml = xml.concat("<?xml version=\"1.0\" encoding=\"UTF-8\"?><archivo tipo=\"ln\">\n");

		for (int i = 0; i < blackList.size(); i++) {
			xml = xml.concat("\t<tarjeta>\n");
			String c1 = String.format("\t\t<c1>%s</c1>\n", blackList.get(i).getUid());
			String c2 = String.format("\t\t<c2>%s</c2>\n", blackList.get(i).getLogic_number());
			xml = xml.concat(c1);
			xml = xml.concat(c2);
			xml = xml.concat("\t</tarjeta>\n");
		}

		xml = xml.concat("</archivo>");

		//System.out.println(xml);

		if (blackList.isEmpty()) {
			return null;
		} else {
			return xml;
		}
		
	}
	
	
	
	public static OpeBlackListCard insertBlackListCard(BlackListService blackListService, AccessRequest arTmp, String pcn, String requesting_user, String reason) {
		
		OpeBlackListCard opeListCard = new OpeBlackListCard(arTmp, pcn, requesting_user, reason);
		
		OpeBlackListCard resp = blackListService.insertBlackListCard(opeListCard);
		
		
		return resp;
	}
	
public static OpeBlackListCard insertBlackListCard(BlackListService blackListService, AccessRequest2 arTmp, String pcn, String requesting_user, String reason) {
		
		OpeBlackListCard opeListCard = new OpeBlackListCard(arTmp, pcn, requesting_user, reason);
		
		OpeBlackListCard resp = blackListService.insertBlackListCard(opeListCard);
		
		
		return resp;
	}
	
	


}
