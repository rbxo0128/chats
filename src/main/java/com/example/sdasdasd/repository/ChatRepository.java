package com.example.sdasdasd.repository;

import com.example.sdasdasd.model.dto.Chat;
import com.example.sdasdasd.model.dto.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByChatroom(Chatroom chatroom);
    List<Chat> findByChatroomOrderByCreatedAtDesc(Chatroom chatroom);
}