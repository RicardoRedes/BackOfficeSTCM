package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.OpeTransportConfig;

public interface OpeTransportConfigRepository extends JpaRepository<OpeTransportConfig, Long> {
	
	@Query(value = "SELECT * FROM movil_device.configs.ope_transport_config "
			+ "WHERE id_line = :transportLineId", nativeQuery = true)
	OpeTransportConfig getTransportConfig(int transportLineId);
	
}
