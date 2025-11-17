package com.trindade.digital_wallet.dtos;

import com.trindade.digital_wallet.domain.UserRole;

import java.math.BigDecimal;

public record UserDTO (String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserRole role) {}
