package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeStores;

public interface OpeStoresRepository extends JpaRepository<OpeStores, Long>{
	@Query(value = "SELECT * FROM oxxo_prepago.dbo.ope_stores WHERE code_store = :code_store",
			  nativeQuery = true)
	OpeStores getStoreByCode(@Param("code_store") String code_store);
	
	
}
