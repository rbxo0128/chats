package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.Chatroom;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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

}