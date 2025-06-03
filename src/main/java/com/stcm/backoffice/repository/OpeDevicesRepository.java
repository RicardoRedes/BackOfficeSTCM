package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.OpeDevices;

public interface OpeDevicesRepository extends JpaRepository<OpeDevices, Long> {

	@Query(value = "SELECT id, manuf_serial_number, id_urbani, id_validator, last_connection, count_connection, device_type, created_at, updated_at, status "
			+ "FROM movil_device.inventory.ope_devices ", nativeQuery = true)
	List<OpeDevices> getAll();

	
	@Query(value = "SELECT * FROM movil_device.inventory.ope_devices "
			+ "WHERE id_urbani = :id_urbani AND id_validator = :id_validator", nativeQuery = true)
	OpeDevices existDevice(String id_urbani, String id_validator);
}
