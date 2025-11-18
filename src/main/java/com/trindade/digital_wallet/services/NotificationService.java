package com.trindade.digital_wallet.services;

import com.trindade.digital_wallet.domain.User;
import com.trindade.digital_wallet.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço responsável por gerenciar operações relacionadas a notificações.
 */
@Service
public class NotificationService {
	@Autowired
	private RestTemplate rest;

	// Envia uma notificação para o usuário
	public void sendNotification(User u, String msg) throws Exception {
		String email = u.getEmail();
		NotificationDTO notificationRequest = new NotificationDTO(u.getEmail(), msg);

		// Envia a solicitação POST para o serviço de notificação
//		ResponseEntity<String> res = rest.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

		// Verifica o status da resposta
//		if (res.getStatusCode() == HttpStatus.OK) {
//			System.out.println("Notificação enviada com sucesso para " + email);
//		} else {
//			System.out.println("Falha ao enviar notificação para " + email);
//			throw new Exception("Falha ao enviar notificação.");
//		}

		System.out.println("Notificacao enviada para o usuario.");
	}
}
