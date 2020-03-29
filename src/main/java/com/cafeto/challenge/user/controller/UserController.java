package com.cafeto.challenge.user.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.user.service.UserService;
import com.cafeto.challenge.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Lazy;

@RestController
@RequestMapping(Constants.URI_USER)
@Lazy
@CrossOrigin
public class UserController extends ControllerBase<User> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

}
