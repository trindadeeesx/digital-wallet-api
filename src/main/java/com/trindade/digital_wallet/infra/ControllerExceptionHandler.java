package com.trindade.digital_wallet.infra;

import com.trindade.digital_wallet.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity treatDuplicateEntry(DataIntegrityViolationException exc) {
		ExceptionDTO expD = new ExceptionDTO("Usuário já cadastrado.", "400");
		return ResponseEntity.badRequest().body(expD);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity treat404(EntityNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity treatGeneralExceptions(Exception exc) {
		ExceptionDTO expD = new ExceptionDTO(exc.getMessage(), "500");
		return ResponseEntity.internalServerError().body(expD);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity treatHttp(HttpClientErrorException exc) {
		return ResponseEntity.internalServerError().body(exc);
	}

}
