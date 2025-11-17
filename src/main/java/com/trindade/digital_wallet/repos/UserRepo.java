package com.trindade.digital_wallet.repos;

import com.trindade.digital_wallet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para gerenciar usuários no sistema
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	/**
	 * Busca um usuário pelo documento
	 * @param document
	 * @return
	 */
	Optional<User> findUserByDocument(String document);
	// porque o Optional?
	// para evitar o famoso NullPointerException
	// caso o usuário não seja encontrado, o Optional retorna um objeto vazio ao invés de null
	// assim, podemos usar métodos do Optional para tratar a ausência do valor de forma mais segura

	/**
	 * Busca um usuário pelo email
	 * @param email
	 * @return
	 */
	Optional<User> findUserByEmail(String email);
	// mesma lógica do método acima
	// usamos Optional para evitar NullPointerException
	// caso o usuário não seja encontrado pelo email
	// podemos tratar a ausência do valor de forma segura usando os métodos do Optional
  // Exemplo: userRepo.findUserByEmail(email).ifPresent(user -> { ... });
}
