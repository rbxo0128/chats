package com.example.sdasdasd.service;

import com.example.sdasdasd.model.dto.Chat;
import com.example.sdasdasd.model.dto.Chatroom;
import com.example.sdasdasd.model.dto.PetUser;
import com.example.sdasdasd.repository.ChatRepository;
import com.example.sdasdasd.repository.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatroomRepository chatroomRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, ChatroomRepository chatroomRepository) {
        this.chatRepository = chatRepository;
        this.chatroomRepository = chatroomRepository;
    }

    @Transactional(readOnly = true)
    public List<Chatroom> getUserChatrooms(PetUser user) {
        return chatroomRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public List<Chatroom> getTrainerChatrooms(PetUser trainer) {
        return chatroomRepository.findByTrainer(trainer);
    }

    @Transactional
    public Chatroom createChatroom(PetUser user, PetUser trainer) {
        // Check if chatroom already exists
        Optional<Chatroom> existingChatroom = chatroomRepository.findByUserAndTrainer(user, trainer);
        if (existingChatroom.isPresent()) {
            return existingChatroom.get();
        }

        // Create new chatroom
        Chatroom chatroom = new Chatroom();
        chatroom.setUser(user);
        chatroom.setTrainer(trainer);
        chatroom.setCreatedAt(LocalDateTime.now());
        chatroom.setUpdatedAt(LocalDateTime.now());
        
        return chatroomRepository.save(chatroom);
    }

    @Transactional(readOnly = true)
    public Optional<Chatroom> getChatroom(Long chatroomId) {
        return chatroomRepository.findById(chatroomId);
    }

    @Transactional(readOnly = true)
    public List<Chat> getChatMessages(Chatroom chatroom) {
        return chatRepository.findByChatroomOrderByCreatedAtDesc(chatroom);
    }

    @Transactional
    public Chat sendMessage(Chatroom chatroom, String content) {
        Chat chat = new Chat();
        chat.setChatroom(chatroom);
        chat.setContent(content);
        chat.setCreatedAt(LocalDateTime.now());
        
        // Update chatroom's updatedAt timestamp
        chatroom.setUpdatedAt(LocalDateTime.now());
        chatroomRepository.save(chatroom);
        
        return chatRepository.save(chat);
    }
}