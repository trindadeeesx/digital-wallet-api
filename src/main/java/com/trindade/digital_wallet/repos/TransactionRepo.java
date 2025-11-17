package com.trindade.digital_wallet.repos;

import com.trindade.digital_wallet.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepo extends JpaRepository<Transaction, Long> {}
