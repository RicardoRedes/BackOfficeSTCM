package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeBlackListSam;

public interface OpeBlackListSamRepository extends JpaRepository<OpeBlackListSam, Long>{
	
	@Query(value = "SELECT id, uid_sam, reason, comment, created_at, updated_at, status, is_sent FROM metrorrey.sch_pry_mty.ope_blacklist_sam WHERE uid_sam = :uid_sam",
			nativeQuery = true)
	OpeBlackListSam retrieveBlackListByUidSam(@Param("uid_sam") String uid_sam);

}
