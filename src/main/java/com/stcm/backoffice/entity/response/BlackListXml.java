package com.stcm.backoffice.entity.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.stcm.backoffice.entity.OpeBlackListCard;


@XmlRootElement(name="tarjeta")
public class BlackListXml {

	private String c1;
	private String c2;
	
	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public BlackListXml() {}
	
	public BlackListXml(OpeBlackListCard black){
		c1 = black.getUid();
		c2 = black.getLogic_number();
	}
}

