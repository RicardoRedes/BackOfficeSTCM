package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeUser;

public interface OpeUsersRepository extends JpaRepository<OpeUser, Long>{

	@Query(value = "SELECT ou.id, ou.employee_identifier, ou.code AS password, our.role, ou.username, ou.status_user AS status, cr.name AS profile "
			+ "FROM metrorrey.sch_pry_mty.ope_user ou "
			+ "INNER JOIN metrorrey.sch_pry_mty.ope_user_role our ON our.id_user = ou.id "
			+ "INNER JOIN metrorrey.sch_pry_mty.cat_role cr ON cr.code = our.role "
			+ "WHERE cr.code = :code " , nativeQuery = true)

	List<OpeUser> retrieveUsers(@Param("code") String code);
}
