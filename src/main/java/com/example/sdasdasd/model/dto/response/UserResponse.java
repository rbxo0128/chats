package com.example.sdasdasd.model.dto.response;

import com.example.sdasdasd.model.dto.PetUser;
import lombok.Data;

@Data
public class UserResponse {
    private String userId;
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

}