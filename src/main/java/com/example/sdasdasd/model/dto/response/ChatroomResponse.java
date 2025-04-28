package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.Chatroom;

import java.time.LocalDateTime;

public class ChatroomResponse {
    private Long chatroomId;
    private UserResponse user;
    private UserResponse trainer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor to convert from entity
    public ChatroomResponse(Chatroom chatroom) {
        this.chatroomId = chatroom.getChatroomId();
        this.user = new UserResponse(chatroom.getUser());
        this.trainer = new UserResponse(chatroom.getTrainer());
        this.createdAt = chatroom.getCreatedAt();
        this.updatedAt = chatroom.getUpdatedAt();
    }

    // Getters and Setters
    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public UserResponse getTrainer() {
        return trainer;
    }

    public void setTrainer(UserResponse trainer) {
        this.trainer = trainer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}