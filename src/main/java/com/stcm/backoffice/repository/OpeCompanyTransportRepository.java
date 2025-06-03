package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeCompanyTransport;

public interface OpeCompanyTransportRepository extends JpaRepository<OpeCompanyTransport, Long> {
	
	@Query(value = "SELECT id, id_company, company_name, created_at, updated_at "
			+ "FROM movil_device.inventory.ope_company_transport ", nativeQuery = true)
	List<OpeCompanyTransport> getAll();

	@Query(value = "SELECT id, id_company, company_name, created_at, updated_at "
			+ "FROM movil_device.inventory.ope_company_transport oct WHERE oct.id = :id", nativeQuery = true)
	OpeCompanyTransport getById(@Param("id") long id);

}
