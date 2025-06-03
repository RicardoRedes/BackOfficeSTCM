package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.CatType;

public interface CatTypeAfcEquipmentRepository extends JpaRepository<CatType,Long>{
	
	
	@Query(value = "SELECT id, code, name, abbreviation, comment, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.cat_type_afc_equipment", nativeQuery = true)
	List<CatType> getAll();
	
	@Query(value = "SELECT id, code, name, abbreviation, comment, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.cat_type_afc_equipment WHERE code =:code", nativeQuery = true)
	CatType findByCode(@Param("code") String code);
}
