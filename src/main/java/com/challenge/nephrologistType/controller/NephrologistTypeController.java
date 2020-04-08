package com.challenge.nephrologistType.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.nephrologistType.model.NephrologistType;
import com.challenge.nephrologistType.service.NephrologistTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_NEPHROLOGIST_TYPE)
@Lazy
public class NephrologistTypeController extends ControllerBase<NephrologistType> {

    @Autowired
    public NephrologistTypeController(NephrologistTypeService service) {
        super(service);
    }

}
