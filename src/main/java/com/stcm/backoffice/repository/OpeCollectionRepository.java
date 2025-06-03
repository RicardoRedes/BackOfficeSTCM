package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeCollection;

public interface OpeCollectionRepository extends JpaRepository<OpeCollection, Long> {
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_collection oc WHERE oc.id = :id", nativeQuery = true)
	OpeCollection getById(@Param("id") long id);

}
