package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.OpeBusUnitsDetails;

public interface OpeBusUnitDetailRepository extends JpaRepository<OpeBusUnitsDetails, Long> {

	@Query(value = "SELECT obu.id, obu.equipment_code, obu.nomenclature, obu.license_plate_icv, obu.eco_number, obu.bus_niv, obu.created_at, obu.updated_at, obu.bus_brand, "
			+ "otr.route_branch, os.pcn_sam, os.uid_sam, os2.id_sim, os2.phone_number, oct.company_name "
			+ "FROM movil_device.inventory.ope_bus_units obu "
			+ "INNER JOIN movil_device.inventory.ope_inventory oi ON obu.id = oi.id_bus "
			+ "INNER JOIN movil_device.inventory.ope_transport_routes otr ON oi.id_route = otr.id "
			+ "INNER JOIN movil_device.inventory.ope_company_transport oct ON oi.id_company_transport = oct.id "
			+ "INNER JOIN movil_device.inventory.ope_sim os2 ON oi.id_sim = os2.id "
			+ "INNER JOIN movil_device.inventory.ope_sam os ON oi.id_sam = os.id ", nativeQuery = true)
	List<OpeBusUnitsDetails> getAllDetails();

}
