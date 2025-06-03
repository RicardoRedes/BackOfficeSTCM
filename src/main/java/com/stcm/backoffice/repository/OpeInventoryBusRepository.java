package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeInventoryBus;

public interface OpeInventoryBusRepository extends JpaRepository<OpeInventoryBus, Long> {

	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_inventory_bus "
			+ "WHERE col_eco = :eco AND col_serie = :vin", nativeQuery = true)
	OpeInventoryBus checkIfBusExists(@Param("eco") String eco, @Param("vin") String vin);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_inventory_bus "
			+ "SET col_branch = :ramal, col_route = :ruta, col_company_service = :tipoRuta, equipment_code = :equipment_code "
			+ "WHERE col_id = :id", nativeQuery = true)
	int updateBus(@Param("id") long id, @Param("ramal") String ramal, @Param("ruta") String ruta,
			@Param("tipoRuta") String tipoRuta, @Param("equipment_code") String equipment_code);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_inventory_bus "
			+ "SET col_bus_id = :nsd, col_sim_id = :sim, col_sam_id = :sam, col_validator = :validatorId, col_brand = :marca, status = 1 "
			+ "WHERE col_id = :id", nativeQuery = true)
	int updateInventoryBusFromDevice(@Param("id") long id, @Param("nsd") String nsd, @Param("sam") String sam,
			@Param("sim") String sim, @Param("validatorId") String validatorId, @Param("marca") String marca);

}
