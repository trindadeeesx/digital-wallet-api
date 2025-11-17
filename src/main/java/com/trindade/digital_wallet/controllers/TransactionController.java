package com.trindade.digital_wallet.controllers;

import com.trindade.digital_wallet.domain.Transaction;
import com.trindade.digital_wallet.dtos.TransactionDTO;
import com.trindade.digital_wallet.services.TransactionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService service;

	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO body) throws Exception {
		Transaction transaction = this.service.createTransaction(body);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
}
