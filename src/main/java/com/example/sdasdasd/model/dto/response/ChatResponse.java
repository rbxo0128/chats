package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.Chat;

import java.time.LocalDateTime;

public class ChatResponse {
    private Long chatId;
    private Long chatroomId;
    private String content;
    private LocalDateTime createdAt;

    // Constructor to convert from entity
    public ChatResponse(Chat chat) {
        this.chatId = chat.getChatId();
        this.chatroomId = chat.getChatroom().getChatroomId();
        this.content = chat.getContent();
        this.createdAt = chat.getCreatedAt();
    }

    // Getters and Setters
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}