package com.stcm.backoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stcm.backoffice.entity.TransactionQR;

public interface TransactionQrRepository extends JpaRepository<TransactionQR, Long>{
		
}
