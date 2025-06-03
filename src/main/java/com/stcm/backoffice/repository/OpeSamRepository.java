package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeSam;

public interface OpeSamRepository extends JpaRepository<OpeSam, Long> {

	@Query(value = "SELECT TOP 1 * FROM movil_device.inventory.ope_sam "
			+ "WHERE uid_sam = :sam", nativeQuery = true)
	OpeSam existsByUiSam(@Param("sam") String sam);
	
}
