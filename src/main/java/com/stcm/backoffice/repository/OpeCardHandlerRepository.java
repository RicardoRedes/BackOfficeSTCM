package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeCardHandler;

public interface OpeCardHandlerRepository extends JpaRepository<OpeCardHandler, Long> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE ope_access_id, ope_topup_id, card_sequence, debit_amount, recharge_amoun, total_amount, updated_at, id_status "
			+ "FROM metrorrey.sch_pry_mty.ope_card_handler WHERE uid = :uid", nativeQuery = true)
	int updateCardHandlerByUid(@Param("uid") String uid);

	

}
