package com.stcm.backoffice.service;


import com.stcm.backoffice.entity.OpeSettings;

public interface SettingsService {
	
	OpeSettings getSettingsByName(String name);
}
