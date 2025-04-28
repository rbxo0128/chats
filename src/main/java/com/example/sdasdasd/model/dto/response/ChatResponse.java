package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.Chat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
    
}