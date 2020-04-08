package com.challenge.api.security.model;

import com.challenge.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {

    private Boolean access;
    private String token;
    private User user;

}
