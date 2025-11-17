package com.trindade.digital_wallet.domain;

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
}
