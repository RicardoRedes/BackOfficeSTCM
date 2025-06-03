package com.stcm.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stcm.backoffice.entity.OpeSettings;
import com.stcm.backoffice.repository.OpeSettingsRepository;
import com.stcm.backoffice.service.SettingsService;

@Service
public class SettingsServiceImpl implements SettingsService{

	@Autowired
	OpeSettingsRepository opeSettingsRepository;  
	
	@Override
	public OpeSettings getSettingsByName(String name) {
		return opeSettingsRepository.getByName(name);
	}

}
