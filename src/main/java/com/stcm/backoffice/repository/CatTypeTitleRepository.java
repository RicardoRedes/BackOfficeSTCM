package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.CatTypeTitle;

public interface CatTypeTitleRepository extends JpaRepository<CatTypeTitle,Long>{
	
	@Query(value = "SELECT id, code, name, abbreviation, comment, packaging, category, synchronizes, assignates, created_at, updated_at, status, type_bond "
			+ "FROM metrorrey.sch_pry_mty.cat_type_title", nativeQuery = true)
	List<CatTypeTitle> getList();
	
	@Query(value = "SELECT id, code, name, abbreviation, comment, packaging, category, synchronizes, assignates, created_at, updated_at, status, type_bond "
			+ "FROM metrorrey.sch_pry_mty.cat_type_title WHERE code = :code AND status = :status", nativeQuery = true)
	CatTypeTitle getTypeTitleByCodeAndStatus(@Param("code")String code, @Param("status")int status);
}
