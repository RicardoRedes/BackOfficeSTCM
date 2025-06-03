package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stcm.backoffice.entity.OpePlaces;

@Repository
public interface OpePlacesRepository extends JpaRepository<OpePlaces, Long> {
	@Query(value = "SELECT * FROM oxxo_prepago.dbo.ope_places WHERE code_place = :code_place",
			  nativeQuery = true)
	OpePlaces getByCode(@Param("code_place") String code_place);

}
