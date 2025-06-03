package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeEventStatistics;

public interface OpeEventStatisticsRepository extends JpaRepository<OpeEventStatistics, Long> {

	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_event_statistics "
			+ "WHERE id_company = :id_company AND event_type = :event_type AND event_code = :event_code AND "
			+ "equipment_type = :equipment_type AND id_equipment = :id_equipment", nativeQuery = true)
	
	OpeEventStatistics retrieveEventStatistics(@Param("id_company") int id_company, @Param("event_type")int event_type, @Param("event_code")int event_code, 
			@Param("equipment_type")int equipment_type, @Param("id_equipment")long id_equipment);
	
	
	//UPDATE 
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_event_statistics "
			+ "SET updated_at = GETDATE(), counter = counter + 1, active = :active "
			+ "WHERE id = :id", nativeQuery = true)
	int updateEventStatistics(@Param("id") long id, @Param("active") int active);
	

}
