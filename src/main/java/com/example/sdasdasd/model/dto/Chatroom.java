package com.example.sdasdasd.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chatrooms")
public class Chatroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatroomId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PetUser user;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private PetUser trainer; // 같은 users 테이블 사용

    @CreatedDate
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
