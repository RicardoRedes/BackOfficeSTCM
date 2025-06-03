package com.stcm.backoffice.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stcm.backoffice.entity.OpeInitializationOrder;

public interface OpeInitializationOrderRepository extends JpaRepository<OpeInitializationOrder, Long>{
	
	@Query(value = "SELECT id, code, total_cards, processed_cards, recharge_amount, requesting_user, created_at, updated_at, status, accepted_cards, declined_cards, title_cards, category_cards, bond_amount, cost_card, task_type, init_task, equipment_code, admin_user "
			+ "FROM metrorrey.sch_pry_mty.ope_initialization_order o "
			+ "WHERE (:code IS NULL OR o.code = :code) "
			+ "AND (:open = 0 OR o.processed_cards < o.total_cards) "
			+ "AND o.status = 1 "
			+ "AND o.created_at BETWEEN :from AND :to "
			+ "AND (:equipmentCode IS NULL OR o.equipment_code = :equipmentCode) "
			+ "ORDER BY o.id ASC ",
			  nativeQuery = true)
	List<OpeInitializationOrder> findFilter(@Param("code") String code, @Param("open") Boolean open, @Param("from") Timestamp from, @Param("to") Timestamp to, @Param("equipmentCode") String equipmentCode);
	
	@Query(value = "SELECT id, code, total_cards, processed_cards, recharge_amount, requesting_user, created_at, updated_at, status, accepted_cards, declined_cards, title_cards, category_cards, bond_amount, cost_card, task_type, init_task, equipment_code, admin_user "
			+ "FROM metrorrey.sch_pry_mty.ope_initialization_order o "
			+ "WHERE (:code IS NULL OR o.code = :code) ",
			  nativeQuery = true)
	OpeInitializationOrder findByCode(@Param("code") String code);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE metrorrey.sch_pry_mty.ope_initialization_order "
			+ "SET processed_cards=:processed_cards, updated_at=:updated_at, accepted_cards=:accepted_cards, declined_cards=:declined_cards, init_task=:init_task "
			+ "WHERE id=:id",
			  nativeQuery = true)
	int update(@Param("id") long id, @Param("processed_cards") int processed_cards, @Param("updated_at") String updated_at, @Param("accepted_cards") int accepted_cards, @Param("declined_cards") int declined_cards, @Param("init_task") String init_task);

	
	@Query(value = "SELECT TOP(1) id, code, total_cards, processed_cards, recharge_amount, requesting_user, created_at, updated_at, status, accepted_cards, declined_cards, title_cards, category_cards, bond_amount, cost_card, task_type, init_task, equipment_code, admin_user "
			+ "FROM metrorrey.sch_pry_mty.ope_initialization_order o "
			+ "ORDER BY o.id DESC ",
			  nativeQuery = true)
	OpeInitializationOrder findLastId();
}
