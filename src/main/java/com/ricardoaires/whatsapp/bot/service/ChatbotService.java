package com.ricardoaires.whatsapp.bot.service;

import com.ricardoaires.whatsapp.bot.model.Conversation;
import com.ricardoaires.whatsapp.bot.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final ConversationRepository repository;

    public String processMessage(String phone, String message) {

        Conversation conversation = repository.findByPhone(phone)
                .orElse(Conversation.builder()
                        .phone(phone)
                        .state("START")
                        .build());

        String response;

        switch (conversation.getState()) {

            case "START" -> {
                response = mainMenu();
                conversation.setState("MAIN_MENU");
            }

            case "MAIN_MENU" -> {
                response = handleMainMenu(conversation, message);
            }

            case "FINANCEIRO" -> {
                response = handleFinanceiro(conversation, message);
            }

            default -> {
                response = mainMenu();
                conversation.setState("MAIN_MENU");
            }
        }

        repository.save(conversation);
        return response;
    }

    private String mainMenu() {
        return """
                Olá! 👋

                Escolha uma opção:

                1️⃣ Financeiro
                2️⃣ Suporte
                3️⃣ Comercial
                4️⃣ Falar com atendente
                """;
    }

    private String handleMainMenu(Conversation conversation, String msg) {

        return switch (msg.trim()) {

            case "1" -> {
                conversation.setState("FINANCEIRO");
                yield """
                        💰 Financeiro

                        1 - Segunda via de boleto
                        2 - Confirmar pagamento
                        3 - Voltar ao menu
                        """;
            }

            case "2" -> "🔧 Nosso suporte responderá em breve.";

            case "3" -> "📞 Comercial: (11) 99999-9999";

            case "4" -> "👨‍💼 Encaminhando para um atendente humano.";

            default -> "❌ Opção inválida.\n\n" + mainMenu();
        };
    }

    private String handleFinanceiro(Conversation conversation, String msg) {

        return switch (msg.trim()) {

            case "1" -> "📄 Informe seu CPF para gerar a segunda via.";

            case "2" -> "💳 Envie o comprovante de pagamento.";

            case "3" -> {
                conversation.setState("MAIN_MENU");
                yield mainMenu();
            }

            default -> "❌ Opção inválida do Financeiro.";
        };
    }
}