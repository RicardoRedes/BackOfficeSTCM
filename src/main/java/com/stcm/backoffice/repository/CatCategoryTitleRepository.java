package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stcm.backoffice.entity.CatCategoryTitle;

public interface CatCategoryTitleRepository extends JpaRepository<CatCategoryTitle,Long>{
	
	@Query(value = "SELECT id, code, name, abbreviation, comment, created_at, updated_at, status "
			+ "FROM metrorrey.sch_pry_mty.cat_category_title", nativeQuery = true)
	List<CatCategoryTitle> getList();
}
