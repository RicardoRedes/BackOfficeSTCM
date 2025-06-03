package com.stcm.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeAfcEquipment;

public interface OpeAfcEquipmentRepository extends JpaRepository<OpeAfcEquipment,Long>{
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_afc_equipment oae WHERE oae.code = :code", nativeQuery = true)
	OpeAfcEquipment getByCode(@Param("code") String code);
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_afc_equipment oae WHERE oae.id = :id", nativeQuery = true)
	OpeAfcEquipment getById(@Param("id") long id);
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_afc_equipment oae WHERE oae.type = :type", nativeQuery = true)
	List<OpeAfcEquipment> getByType(@Param("type") String type);
	
	@Query(value = "SELECT TOP 1 CAST(ip_address AS NVARCHAR(MAX)) FROM metrorrey.sch_pry_mty.ope_afc_equipment "
			+ "WHERE id_station = :idStation ORDER BY code DESC", nativeQuery = true)
	String obtenerUltimoConsecutivo(@Param("idStation") String idStation);
	
	@Query(value = "SELECT * FROM metrorrey.sch_pry_mty.ope_afc_equipment oae WHERE oae.code = :code AND oae.status = :status", nativeQuery = true)
	OpeAfcEquipment getByCodeAndStatus(@Param("code")String code, @Param("status")int status);
	
	@Query(value = "SELECT oae.* FROM metrorrey.sch_pry_mty.ope_afc_equipment oae "
					+ "INNER JOIN metrorrey.sch_pry_mty.ope_transport_station ots ON oae.id_station = ots.id "
					+ "WHERE ots.name = :name", nativeQuery = true)
	List<OpeAfcEquipment> getByStationName(@Param("name") String name);
	
}
