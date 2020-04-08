package com.challenge.clinic.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.clinic.model.Clinic;
import com.challenge.clinic.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_CLINIC)
@Lazy
public class ClinicController extends ControllerBase<Clinic> {

    @Autowired
    public ClinicController(ClinicService service) {
        super(service);
    }
}
