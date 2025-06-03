package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeTransportRoutes;

public interface OpeTransportRouteRepository extends JpaRepository<OpeTransportRoutes, Long> {

	@Query(value = "SELECT id, code_stcm, start_point, end_point, route_branch, route_size, created_at, updated_at, id_company_transport, id_company_contract, route_code "
			+ "FROM movil_device.inventory.ope_transport_routes ", nativeQuery = true)
	List<OpeTransportRoutes> getAll();

	@Query(value = "SELECT * FROM movil_device.inventory.ope_transport_routes "
			+ "WHERE route_code = :routeCode AND route_branch = :routeBranch", nativeQuery = true)
	OpeTransportRoutes checkIfRouteExists(@Param("routeCode") String ruta, @Param("routeBranch") String ramal);

}
