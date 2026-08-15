package com.ricardo.bot.controller;

import com.ricardo.bot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final ChatbotService chatbotService;

    @PostMapping
    public String receive(@RequestBody Map<String, Object> body) {

        String phone = "5511999999999";
        String message = body.getOrDefault("message", "").toString();

        return chatbotService.processMessage(phone, message);
    }

    @GetMapping
    public String verify(@RequestParam("hub.challenge") String challenge) {
        return challenge;
    }
}d