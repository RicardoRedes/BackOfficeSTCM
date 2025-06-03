package com.stcm.backoffice.service;

import com.stcm.backoffice.entity.OpeCollection;

public interface CollectionService {

	/*
	 * 
	 * Collection
	 * 
	 */
	OpeCollection retrieveCollection(long id);

	OpeCollection insertCollection(OpeCollection collection);
	
}
