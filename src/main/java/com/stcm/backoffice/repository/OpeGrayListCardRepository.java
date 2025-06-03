package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeGrayListCard;


public interface OpeGrayListCardRepository extends JpaRepository<OpeGrayListCard,Long>{
	@Query(value = "SELECT TOP 1 id, uid, logic_number FROM bitshield.dbo.ope_gray_list_card WHERE logic_number =:logic_number",
			nativeQuery = true)
	OpeGrayListCard retrieveGrayElement(@Param("logic_number") String logic_number);
}