package com.cafeto.challenge.clinic.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.clinic.model.Clinic;
import com.cafeto.challenge.clinic.service.ClinicService;
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
