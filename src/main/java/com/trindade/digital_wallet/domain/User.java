package com.trindade.digital_wallet.domain;

import com.trindade.digital_wallet.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Entidade que representa um usuário do sistema
 */
@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	@Column(unique=true)
	private String email;

	@Column(unique=true)
	private String document; // CPF/CNPJ

	private String password; // won't be used

	private BigDecimal balance; // user's wallet balance

	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User(UserDTO data) {
		this.firstName = data.firstName();
		this.lastName = data.lastName();
		this.email = data.email();
		this.document = data.document();
		this.password = data.password();
		this.balance = data.balance();
		this.role = data.role();
	}
}
