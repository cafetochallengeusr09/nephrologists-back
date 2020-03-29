package com.cafeto.challenge.nephrologistType.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.nephrologistType.model.NephrologistType;
import com.cafeto.challenge.nephrologistType.service.NephrologistTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_NEPHROLOGIST_TYPE)
@Lazy
@CrossOrigin
public class NephrologistTypeController extends ControllerBase<NephrologistType> {

    @Autowired
    public NephrologistTypeController(NephrologistTypeService service) {
        super(service);
    }

}
