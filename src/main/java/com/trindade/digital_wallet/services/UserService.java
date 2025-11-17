package com.trindade.digital_wallet.services;

import com.trindade.digital_wallet.domain.User;
import com.trindade.digital_wallet.domain.UserRole;
import com.trindade.digital_wallet.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Serviço responsável por gerenciar operações relacionadas ao usuário.
 */
@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	// Valida uma transação antes de sua execução
	public void validateTransaction(User sender, BigDecimal transactionAmount) throws Exception {
		// Verifica se o remetente é um comerciante
		if (sender.getRole() == UserRole.MERCHANT) {
			throw new Exception("Comerciantes não podem iniciar transações.");
		}

		// Verifica se o saldo do remetente é suficiente para a transação
		if (sender.getBalance().compareTo(transactionAmount) < 0) {
			throw new Exception("Saldo insuficiente para completar a transação.");
		}

		// Se todas as validações passarem, a transação pode prosseguir
	}

	// Busca um usuário pelo seu ID
	public User findUserById(Long userId) throws Exception {
		return this.userRepo.findById(userId).orElseThrow(() -> new Exception("Usuário não encontrado."));
	}

	// Salva ou atualiza um usuário no repositório
	public void saveUser(User user) {
		this.userRepo.save(user);
	}
}
