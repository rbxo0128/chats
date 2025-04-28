package com.example.sdasdasd.model.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public PetUser getUser() {
        return user;
    }

    public void setUser(PetUser user) {
        this.user = user;
    }

    public PetUser getTrainer() {
        return trainer;
    }

    public void setTrainer(PetUser trainer) {
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
