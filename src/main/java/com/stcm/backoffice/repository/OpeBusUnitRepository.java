package com.stcm.backoffice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeBusUnits;

public interface OpeBusUnitRepository extends JpaRepository<OpeBusUnits, Long> {

	@Query(value = "SELECT id, equipment_code, nomenclature, license_plate_icv, eco_number, bus_niv, created_at, updated_at, bus_brand "
			+ "FROM movil_device.inventory.ope_bus_units ", nativeQuery = true)
	List<OpeBusUnits> getAll();
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE movil_device.inventory.ope_bus_units "
			+ "SET equipment_code=:equipment_code "
			+ "WHERE id=:id",
			  nativeQuery = true)
	int update(@Param("id") long id, @Param("equipment_code") String equipment_code);
	
	@Query(value = "SELECT * FROM movil_device.inventory.ope_bus_units "
			+ "WHERE eco_number = :eco AND bus_brand = :marca AND bus_niv = :vin", nativeQuery = true)
	OpeBusUnits checkIfBusExists(String eco, String marca, String vin);
}
