package com.trindade.digital_wallet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidade que representa uma transação financeira entre usuários
 */
@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="sender_id")
	private User sender; // User ID of the sender

	@ManyToOne
	@JoinColumn(name="receiver_id")
	private User receiverId; // User ID of the receiver

	private BigDecimal amount; // Transaction amount

	private LocalDateTime timestamp; // Timestamp of the transaction
}
