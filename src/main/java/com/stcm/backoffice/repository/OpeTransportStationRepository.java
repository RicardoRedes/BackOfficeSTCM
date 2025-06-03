package com.stcm.backoffice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeTransportStation;



public interface OpeTransportStationRepository extends JpaRepository<OpeTransportStation, Long>{

	@Query(value = "SELECT id, id_line, code, name, symbol, [type], comment, created_at, updated_at, status, latitude, longitude, ubication_code "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_station "
			+ "WHERE id_line <> 14;",
			  nativeQuery = true)
	List<OpeTransportStation> retrieveStations();
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_transport_station ots WHERE ots.id = :id", nativeQuery = true)
	OpeTransportStation getById(@Param("id") long id);
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_transport_station ots WHERE ots.name = :name", nativeQuery = true)
	OpeTransportStation getByName(@Param("name") String name);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_transport_station "
			+ "SET code=:code, updated_at=:updated_at "
			+ "WHERE id=:id",
			  nativeQuery = true)
	int update(@Param("id") long id, @Param("code") String code, @Param("updated_at") String updated_at);

}
