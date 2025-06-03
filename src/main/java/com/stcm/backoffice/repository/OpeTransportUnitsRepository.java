package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeTransportUnits;


public interface OpeTransportUnitsRepository extends JpaRepository<OpeTransportUnits, Long>{
	
	@Query(value = "SELECT id, num_unit, plate, serial_number, trademark, model, version, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_units "
			+ "WHERE id = :id", nativeQuery = true)
	OpeTransportUnits findById(@Param("id") long id);
	
	@Query(value = "SELECT id, num_unit, plate, serial_number, trademark, model, version, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_units ", nativeQuery = true)
	List<OpeTransportUnits> getAll();
}
