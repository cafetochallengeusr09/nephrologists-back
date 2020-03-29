package com.cafeto.challenge.api.security.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ResponseBase;
import com.cafeto.challenge.api.security.model.JwtResponse;
import com.cafeto.challenge.user.model.User;
import com.cafeto.challenge.user.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.URI_AUTH)
@Lazy
@CrossOrigin
@Slf4j
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(Constants.URI_AUTH_SIGIN)
    @ResponseBody
    ResponseEntity<?> signIn(@RequestBody @NonNull User model) {
        try {
            log.info("sigin {}", model);
            User body = userService.save(model);
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(Constants.URI_AUTH_LOGIN)
    @ResponseBody
    ResponseEntity<?> logIn(@RequestBody @NonNull User model) {
        try {
            log.info("login {}", model);
            JwtResponse body = userService.login(model);
            return new ResponseEntity(ResponseBase
                    .buildSuccessResponse(body), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ResponseBase
                    .buildErrorResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
