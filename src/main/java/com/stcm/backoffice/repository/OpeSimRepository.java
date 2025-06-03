package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeSim;


public interface OpeSimRepository extends JpaRepository<OpeSim, Long> {

	@Query(value = "SELECT TOP 1 * FROM movil_device.inventory.ope_sim "
			+ "WHERE id_sim = :sim", nativeQuery = true)
	OpeSim existsByIdSim(@Param("sim") String sim);
	
	

}
