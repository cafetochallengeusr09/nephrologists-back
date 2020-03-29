package com.cafeto.challenge.user.service;

import com.cafeto.challenge.api.commons.ServiceBase;
import com.cafeto.challenge.api.security.model.JwtResponse;
import com.cafeto.challenge.user.model.User;

public interface UserService extends ServiceBase<User> {

    JwtResponse login(User model);
}
