package com.ricardoaires.whatsapp.bot.controller;

import com.ricardoaires.whatsapp.bot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final ChatbotService chatbotService;

    @Value("${whatsapp.verify-token}")
    private String verifyToken;

    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam(name = "hub.mode", required = false) String mode,
            @RequestParam(name = "hub.verify_token", required = false) String token,
            @RequestParam(name = "hub.challenge", required = false) String challenge) {

        if ("subscribe".equals(mode) && verifyToken.equals(token)) {
            return ResponseEntity.ok(challenge);
        }

        return ResponseEntity.status(403).body("Token inválido");
    }

    @PostMapping
    public ResponseEntity<Void> receiveWebhook(
            @RequestBody Map<String, Object> body) {

        System.out.println("Webhook recebido:");
        System.out.println(body);

        return ResponseEntity.ok().build();
    }
}