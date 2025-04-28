package com.example.sdasdasd.controller;

import com.example.sdasdasd.model.dto.Chat;
import com.example.sdasdasd.model.dto.Chatroom;
import com.example.sdasdasd.model.dto.PetUser;
import com.example.sdasdasd.model.dto.request.CreateChatroomRequest;
import com.example.sdasdasd.model.dto.request.SendMessageRequest;
import com.example.sdasdasd.model.dto.response.ChatResponse;
import com.example.sdasdasd.model.dto.response.ChatroomResponse;
import com.example.sdasdasd.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/rooms/user/{userId}")
    public ResponseEntity<List<ChatroomResponse>> getUserChatrooms(@PathVariable String userId) {
        // In a real application, you would get the user from a user service or repository
        PetUser user = new PetUser();
        user.setUserId(userId);

        List<Chatroom> chatrooms = chatService.getUserChatrooms(user);
        List<ChatroomResponse> response = chatrooms.stream()
                .map(ChatroomResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // Get all chatrooms for a trainer
    @GetMapping("/rooms/trainer/{trainerId}")
    public ResponseEntity<List<ChatroomResponse>> getTrainerChatrooms(@PathVariable Long trainerId) {
        PetUser trainer = new PetUser();

        List<Chatroom> chatrooms = chatService.getTrainerChatrooms(trainer);
        List<ChatroomResponse> response = chatrooms.stream()
                .map(ChatroomResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // Create a new chatroom
    @PostMapping("/rooms")
    public ResponseEntity<ChatroomResponse> createChatroom(@RequestBody CreateChatroomRequest request) {
        // In a real application, you would get the users from a user service or repository
        PetUser user = new PetUser();

        PetUser trainer = new PetUser();


        Chatroom chatroom = chatService.createChatroom(user, trainer);
        ChatroomResponse response = new ChatroomResponse(chatroom);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get a specific chatroom
    @GetMapping("/rooms/{chatroomId}")
    public ResponseEntity<ChatroomResponse> getChatroom(@PathVariable Long chatroomId) {
        Optional<Chatroom> chatroom = chatService.getChatroom(chatroomId);

        return chatroom.map(c -> ResponseEntity.ok(new ChatroomResponse(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all messages in a chatroom
    @GetMapping("/rooms/{chatroomId}/messages")
    public ResponseEntity<List<ChatResponse>> getChatMessages(@PathVariable Long chatroomId) {
        Optional<Chatroom> chatroom = chatService.getChatroom(chatroomId);

        if (chatroom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Chat> messages = chatService.getChatMessages(chatroom.get());
        List<ChatResponse> response = messages.stream()
                .map(ChatResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // Send a message in a chatroom
    @PostMapping("/rooms/{chatroomId}/messages")
    public ResponseEntity<ChatResponse> sendMessage(
            @PathVariable Long chatroomId,
            @RequestBody SendMessageRequest request) {

        Optional<Chatroom> chatroom = chatService.getChatroom(chatroomId);

        if (chatroom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Chat chat = chatService.sendMessage(chatroom.get(), request.getContent());
        ChatResponse response = new ChatResponse(chat);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}