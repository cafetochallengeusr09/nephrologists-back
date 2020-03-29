package com.cafeto.challenge.nephrologistBaseClinic.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.nephrologistBaseClinic.model.NephrologistBaseClinic;
import com.cafeto.challenge.nephrologistBaseClinic.service.NephrologistBaseClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_NEPHROLOGIST_BASE_CLINIC)
@Lazy
@CrossOrigin
public class NephrologistBaseClinicController extends ControllerBase<NephrologistBaseClinic> {

    @Autowired
    public NephrologistBaseClinicController(NephrologistBaseClinicService service) {
        super(service);
    }
}
