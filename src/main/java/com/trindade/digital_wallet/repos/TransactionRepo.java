package com.trindade.digital_wallet.repos;

import com.trindade.digital_wallet.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para gerenciar transações financeiras entre usuários
 */
public interface TransactionRepo extends JpaRepository<Transaction, Long> {}
