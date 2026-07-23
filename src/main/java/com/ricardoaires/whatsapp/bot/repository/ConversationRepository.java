package com.ricardo.bot.repository;

import com.ricardo.bot.model.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
    Optional<Conversation> findByPhone(String phone);
}