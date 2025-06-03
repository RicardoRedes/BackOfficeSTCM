package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.MetroSchPryDevices;


public interface MetroSchPryDevicesRepository extends JpaRepository<MetroSchPryDevices, Long> {

	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.devices "
			+ "WHERE nsd = :id_urbani", nativeQuery = true)
	MetroSchPryDevices existMetroSchPryDevices(String id_urbani);
	
}
