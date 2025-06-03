package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.OpeTransportType;

public interface OpeTransportTypeRepository extends JpaRepository<OpeTransportType, Long> {

	@Query(value = "SELECT * FROM movil_device.inventory.ope_transport_type "
			+ "WHERE tipo_ruta = :tipoRuta", nativeQuery = true)
	OpeTransportType getTipoRuta(String tipoRuta);
	
}
