package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeTransportLine;


public interface OpeTransportLineRepository extends JpaRepository<OpeTransportLine, Long>{
	
	@Query(value = "SELECT id, id_company, code, name, num_station, color, comment, created_at, updated_at, status, ubication_code "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_line ots WHERE ots.code = :code", nativeQuery = true)
	OpeTransportLine findByCode(@Param("code") String code);
	
	@Query(value = "SELECT id, id_company, code, name, num_station, color, comment, created_at, updated_at, status, ubication_code "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_line ots WHERE ots.id = :id_line", nativeQuery = true)
	OpeTransportLine findById(@Param("id_line") int id_line);
}
