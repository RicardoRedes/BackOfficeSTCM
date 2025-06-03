package com.stcm.backoffice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stcm.backoffice.entity.OpeReaders;

@Repository
public interface OpeReadersRepository extends JpaRepository<OpeReaders, Long>{
	@Query(value = "SELECT * FROM oxxo_prepago.dbo.ope_readers WHERE serial_num = :serial_num AND status = 1",
			  nativeQuery = true)
	OpeReaders retrieveReader(@Param("serial_num") String serial_num);
	
	@Query(value = "SELECT * FROM oxxo_prepago.dbo.ope_readers WHERE id_store = :id_store",
			  nativeQuery = true)
	OpeReaders retrieveReaderStore(@Param("id_store") long id_store);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE oxxo_prepago.dbo.ope_readers "
			+ "SET serial_num = :serial_num, code_cash_register = :code_cash_register, uid_sam = :uid_sam, "
			+ "id_setting = 1, request_count = 1, status = 1, updated_at = GETDATE() "
			+ "WHERE id = :id",
			  nativeQuery = true)
	int updateReader(@Param("id") long id, @Param("serial_num") String serial_num, @Param("code_cash_register") String code_cash_register, @Param("uid_sam") String uid_sam);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE oxxo_prepago.dbo.ope_readers "
			+ "SET updated_at = GETDATE(), request_count = request_count + 1 "
			+ "WHERE id = :id",
			  nativeQuery = true)
	int updateReaderCount(@Param("id") long id);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "UPDATE oxxo_prepago.dbo.ope_readers "
			+ "SET updated_at = GETDATE(), status = :status "
			+ "WHERE id = :id",
			  nativeQuery = true)
	int updateReaderStatus(@Param("id") long id, @Param("status") int status);
}
