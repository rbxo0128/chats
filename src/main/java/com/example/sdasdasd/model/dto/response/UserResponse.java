package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.PetUser;

public class UserResponse {
    private Long userId;
    private String name;
    private String nickname;
    private String profileImageUrl;
    private String status;

    // Constructor to convert from entity
    public UserResponse(PetUser user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.profileImageUrl = user.getProfileImageUrl();
        this.status = user.getStatus();
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}