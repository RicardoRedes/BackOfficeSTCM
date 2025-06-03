package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeInventoryCard;

public interface OpeInventoryCardRepository extends JpaRepository<OpeInventoryCard, Long> {

	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_inventory_card oic WHERE oic.id = :id", nativeQuery = true)
	OpeInventoryCard retrieveInventoryCard(@Param("id") long id);
	
	@Query(value = "SELECT TOP (1) * FROM metrorrey.sch_pry_mty.ope_inventory_card oic WHERE oic.uid = :uid AND oic.logic_number = :logic_number", nativeQuery = true)
	OpeInventoryCard retrieveInventoryCard(@Param("uid") String uid, @Param("logic_number") String logic_number);
	
	@Query(value = "SELECT (1) * FROM metrorrey.sch_pry_mty.ope_inventory_card oic WHERE oic.logic_number = :logic_number", nativeQuery = true)
	OpeInventoryCard retrieveInventoryCard(@Param("logic_number") String logic_number);

	@Query(value = "SELECT TOP (:top) * FROM metrorrey.sch_pry_mty.ope_inventory_card oic WHERE oic.logic_number = '' AND id > :id ORDER BY id ASC", nativeQuery = true)
	List<OpeInventoryCard> retrieveInventoryCards(@Param("id") long id, @Param("top") long top);

}
