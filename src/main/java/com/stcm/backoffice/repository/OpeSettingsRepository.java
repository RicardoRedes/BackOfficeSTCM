package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeSettings;

public interface OpeSettingsRepository extends JpaRepository<OpeSettings, Long>{
	@Query(value = "SELECT id, description, value, status, name "
			+ "FROM metrorrey.sch_pry_mty.ope_settings "
			+ "WHERE name = :name", nativeQuery = true)
	OpeSettings getByName(@Param("name") String name);
}
