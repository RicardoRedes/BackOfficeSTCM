package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.Stations;

public interface StationRepository extends JpaRepository<Stations, Long>{
	
	@Query(value = "SELECT ots.id_line AS line, ots.id AS station, ots.name AS name_station, otl.name AS name_line "
			+ "FROM metrorrey.sch_pry_mty.ope_transport_station ots INNER JOIN metrorrey.sch_pry_mty.ope_transport_line otl ON otl.id = ots.id_line",
			  nativeQuery = true)
	List<Stations> retrieveStations();

}
