package com.stcm.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stcm.backoffice.entity.OpeCollection;
import com.stcm.backoffice.repository.OpeCollectionRepository;
import com.stcm.backoffice.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	/*
	 * 
	 * Collection
	 * 
	 */
	@Autowired
	OpeCollectionRepository collectionRepository;

	@Override
	public OpeCollection retrieveCollection(long id) {
		return collectionRepository.getById(id);
	}

	@Override
	public OpeCollection insertCollection(OpeCollection collection) {
		return collectionRepository.saveAndFlush(collection);
	}
}