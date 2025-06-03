package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.response.DeviceBlackList;
import com.stcm.backoffice.entity.OpeBlackListCard;

public interface OpeBlackListCardRepository extends JpaRepository<OpeBlackListCard,Long>{
	@Query(value = "SELECT TOP 1 id, uid, logic_number FROM bitshield.dbo.ope_black_list_card WHERE logic_number = :logic_number",
			nativeQuery = true)
	OpeBlackListCard retrieveBlackElement(@Param("logic_number") String logic_number);
	
	@Query(value = "SELECT id, uid, logic_number FROM bitshield.dbo.ope_black_list_card WHERE logic_number <> ''",
			nativeQuery = true)
	List<OpeBlackListCard> retrieveBlackList();
	
	@Query(value = "SELECT uid, logic_number FROM bitshield.dbo.ope_black_list_card WHERE logic_number <> ''",
			nativeQuery = true)
	List<DeviceBlackList> retrieveDeviceBlackList();
}