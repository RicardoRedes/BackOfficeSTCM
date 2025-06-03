package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeTransportRoutesDetails;

public interface OpeTransportRouteDetailRepository extends JpaRepository<OpeTransportRoutesDetails, Long> {

	@Query(value = "SELECT otr.id, otr.code_stcm, otr.start_point, otr.end_point, otr.route_branch, otr.route_size, otr.created_at, otr.updated_at, "
			+ "oct.company_name, occ.contract_name " + "FROM movil_device.inventory.ope_transport_routes otr "
			+ "INNER JOIN movil_device.inventory.ope_inventory oi ON otr.id = oi.id_route "
			+ "INNER JOIN movil_device.inventory.ope_company_transport oct ON oi.id_company_transport = oct.id "
			+ "INNER JOIN movil_device.inventory.ope_company_contract occ ON oi.id_company_contract= occ.id ", nativeQuery = true)
	List<OpeTransportRoutesDetails> getAll();

	@Query(value = "SELECT otr.id, otr.code_stcm, otr.start_point, otr.end_point, otr.route_branch, otr.route_size, otr.created_at, otr.updated_at, "
			+ "oct.company_name, occ.contract_name "
			+ "FROM movil_device.inventory.ope_transport_routes otr "
			+ "INNER JOIN movil_device.inventory.ope_company_transport oct ON otr.id_company_transport = oct.id "
			+ "INNER JOIN movil_device.inventory.ope_company_contract occ ON otr.id_company_contract= occ.id "
			+ "WHERE (:route_code IS NULL OR otr.route_code = :route_code) " + "AND (:transport_code IS NULL OR otr.id_company_transport = :transport_code) "
			+ "AND (:contract_code IS NULL OR otr.id_company_contract = :contract_code) "
			+ "ORDER BY oct.company_name ASC ", nativeQuery = true) 
	List<OpeTransportRoutesDetails> findFilter(@Param("route_code") String route_code, @Param("transport_code") String transport_code,
			@Param("contract_code") String contract_code);

}
