package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeEventHist;



public interface OpeEventHistRepository extends JpaRepository<OpeEventHist, Long>{
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_event_hist WHERE id = :id",
			  nativeQuery = true)
	OpeEventHist retrieveEventHist(@Param("id") long id);
	
	
	@Query(value = "SELECT id, event_state, id_equipment, event_type, id_company, event_code, equipment_type\r\n"
			+ "FROM metrorrey.sch_pry_mty.ope_event_hist oeh WHERE id = :id AND event_state = :event_state AND id_equipment = :id_equipment "
			+ "AND event_type = :event_type AND id_company = :id_company AND event_code = :event_code AND equipment_type = :equipment_type",
			  nativeQuery = true)
	OpeEventHist retrieveEventHist(@Param("id") long id, @Param("event_state")int event_state, @Param("id_equipment")long id_equipment,
			@Param("event_type")int event_type, @Param("id_company")long id_company, @Param("event_code")int event_code, @Param("equipment_type") int equipment_type);
	
	//Update eventHist
	
		@Modifying(clearAutomatically=true)
		@Transactional
		@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_event_hist "
				+ "SET updated_at = GETDATE(), event_state = :event_state WHERE id = :id", nativeQuery = true)
		int updateEventHist(@Param("id") long id, @Param("event_state") int event_state);
	
}
