package com.trindade.digital_wallet.services;

import com.trindade.digital_wallet.domain.User;
import com.trindade.digital_wallet.dtos.TransactionDTO;
import com.trindade.digital_wallet.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por gerenciar operações relacionadas a transações.
 */
@Service
public class TransactionService {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionRepo transactionRepo;

	// Cria uma nova transação
	public void createTransaction(TransactionDTO transaction) throws Exception {
		User sender = this.userService.findUserById(transaction.senderId());
		User receiver = this.userService.findUserById(transaction.receiverId());

		userService.validateTransaction(sender, transaction.amount());
	}
}
