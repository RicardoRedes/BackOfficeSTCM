package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeInventory;

public interface OpeInventoryRepository extends JpaRepository<OpeInventory, Long> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE movil_device.inventory.ope_inventory "
			+ "SET id_sim = :idSim, id_sam = :idSam, id_device = :idDevice "
			+ "WHERE id_bus = :idBus", nativeQuery = true)
	int updateInventory(@Param("idBus") long idBus, @Param("idDevice") long idDevice, @Param("idSam") int idSam,
			@Param("idSim") int idSim);
}
