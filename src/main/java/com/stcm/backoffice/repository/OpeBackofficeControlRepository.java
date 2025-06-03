package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeBackofficeControl;


public interface OpeBackofficeControlRepository extends JpaRepository<OpeBackofficeControl, Long>{
	
	@Query(value = "SELECT * FROM oxxo_prepago.dbo.ope_backoffice_control WHERE id = :id",
			  nativeQuery = true)
	OpeBackofficeControl retrieveTopupControl(@Param("id") int id);

}
