package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeAccess;

public interface OpeAccessRepository extends JpaRepository<OpeAccess, Long>{
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_access WHERE id_cde = :id AND id_station = :id_station AND "
			+ "transaction_date = :transaction_date",
			  nativeQuery = true)
	OpeAccess retrieveAccess(@Param("id") long id, @Param("id_station")long id_station, @Param("transaction_date")String transaction_date);
	
	
}
