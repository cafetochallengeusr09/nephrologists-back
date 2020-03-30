package com.cafeto.challenge.nephrologist.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.nephrologist.model.Nephrologist;
import com.cafeto.challenge.nephrologist.service.NephrologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_NEPHROLOGIST)
@Lazy
public class NephrologistController extends ControllerBase<Nephrologist> {

    @Autowired
    public NephrologistController(NephrologistService service) {
        super(service);
    }
}
