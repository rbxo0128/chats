package com.example.sdasdasd.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom;
    private String sender;
    private String receiver;
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;
}
