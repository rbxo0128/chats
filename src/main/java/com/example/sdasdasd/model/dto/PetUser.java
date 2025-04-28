package com.example.sdasdasd.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pet_users")
public class PetUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    private String name;

    private String role;

    @Column(unique = true)
    private String nickname;

    private String profileImageUrl;

    private String status;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
