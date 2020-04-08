package com.challenge.user.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.user.model.User;
import com.challenge.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_USER)
@Lazy
public class UserController extends ControllerBase<User> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

}
