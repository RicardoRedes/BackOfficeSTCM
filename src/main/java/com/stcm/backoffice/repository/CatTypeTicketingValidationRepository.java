package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.CatTypeTicketingValidation;

public interface CatTypeTicketingValidationRepository extends JpaRepository<CatTypeTicketingValidation, Long>{
	
	@Query(value= "SELECT id, code, name, abbreviation, comment, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.cat_type_ticketing_validation WHERE code = :code AND status = :status", nativeQuery = true)
	CatTypeTicketingValidation findCatTicketingByCodeAndStatus(@Param("code")String code, @Param("status")int status);

}
