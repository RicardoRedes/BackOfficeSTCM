package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeCompanyContract;

public interface OpeCompanyContractRepository extends JpaRepository<OpeCompanyContract, Long> {

	@Query(value = "SELECT id, id_contract, contract_name, created_at, updated_at "
			+ "	FROM movil_device.inventory.ope_company_contract occ ", nativeQuery = true)
	List<OpeCompanyContract> getAll();

	@Query(value = "SELECT id, id_contract, contract_name, created_at, updated_at "
			+ "	FROM movil_device.inventory.ope_company_contract occ WHERE occ.id = :id", nativeQuery = true)
	OpeCompanyContract getById(@Param("id") long id);

	@Query(value = "SELECT * FROM movil_device.inventory.ope_company_contract "
			+ "WHERE contract_name = :tipoRuta", nativeQuery = true)
	OpeCompanyContract existsTipoRuta(String tipoRuta);
}
