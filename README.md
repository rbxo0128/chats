# Chat REST API

This project implements a REST API for chat functionality between users and trainers.

## API Endpoints

### Chatrooms

#### Get all chatrooms for a user
```
GET /api/chat/rooms/user/{userId}
```

#### Get all chatrooms for a trainer
```
GET /api/chat/rooms/trainer/{trainerId}
```

#### Create a new chatroom
```
POST /api/chat/rooms
```
Request body:
```json
{
  "userId": 1,
  "trainerId": 2
}
```

#### Get a specific chatroom
```
GET /api/chat/rooms/{chatroomId}
```

### Messages

#### Get all messages in a chatroom
```
GET /api/chat/rooms/{chatroomId}/messages
```

#### Send a message in a chatroom
```
POST /api/chat/rooms/{chatroomId}/messages
```
Request body:
```json
{
  "content": "Hello, how can I help you with your pet?"
}
```

## Data Models

### PetUser
- userId: Long
- name: String
- role: String
- nickname: String
- profileImageUrl: String
- status: String
- createdAt: LocalDateTime
- updatedAt: LocalDateTime

### Chatroom
- chatroomId: Long
- user: PetUser
- trainer: PetUser
- createdAt: LocalDateTime
- updatedAt: LocalDateTime

### Chat
- chatId: Long
- chatroom: Chatroom
- content: String
- createdAt: LocalDateTime

## Setup and Configuration

The application uses MySQL for data storage. Database configuration is loaded from environment variables:
- DB_URL: JDBC URL for the MySQL database
- DB_USERNAME: Database username
- DB_PASSWORD: Database password

These environment variables are defined in the application.properties file.