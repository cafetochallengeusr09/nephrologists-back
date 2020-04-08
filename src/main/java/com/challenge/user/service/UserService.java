package com.challenge.user.service;

import com.challenge.api.commons.ServiceBase;
import com.challenge.api.security.model.JwtResponse;
import com.challenge.user.model.User;

public interface UserService extends ServiceBase<User> {

    JwtResponse login(User model);
}
