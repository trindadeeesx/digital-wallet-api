package com.trindade.digital_wallet.services;

import com.trindade.digital_wallet.domain.Transaction;
import com.trindade.digital_wallet.domain.User;
import com.trindade.digital_wallet.dtos.TransactionDTO;
import com.trindade.digital_wallet.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Serviço responsável por gerenciar operações relacionadas a transações.
 */
@Service
public class TransactionService {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionRepo transactionRepo;

	@Autowired
	private RestTemplate rest;

	// Cria uma nova transação
	public void createTransaction(TransactionDTO transaction) throws Exception {
		User sender = this.userService.findUserById(transaction.senderId());
		User receiver = this.userService.findUserById(transaction.receiverId());

		userService.validateTransaction(sender, transaction.amount());

		boolean authorized = this.authorizeTransaction(sender, transaction.amount());

		// Se a transação não for autorizada, lança uma exceção
		if (!authorized)
			throw new Exception("Transação não autorizada pelo serviço externo.");

		// Cria a nova transação
		Transaction newTransaction = new Transaction();
		newTransaction.setAmount(transaction.amount());
		newTransaction.setSender(sender);
		newTransaction.setReceiver(receiver);
		newTransaction.setTimestamp(LocalDateTime.now());

		// Atualiza os saldos dos usuários envolvidos na transação
		sender.setBalance(sender.getBalance().subtract(transaction.amount()));
		receiver.setBalance(receiver.getBalance().add(transaction.amount()));

		// Salva as alterações no repositório
		this.transactionRepo.save(newTransaction);
		this.userService.saveUser(sender);
		this.userService.saveUser(receiver);
	}

	// Autoriza uma transação via serviço externo
	public boolean authorizeTransaction(User sender, BigDecimal amount) {
		ResponseEntity<Map> res = rest.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class); // Exemplo de chamada externa, hardcoded para ilustração

		return res.getStatusCode() == HttpStatus.OK && res.getBody().get("message").equals("success");
	}
}
