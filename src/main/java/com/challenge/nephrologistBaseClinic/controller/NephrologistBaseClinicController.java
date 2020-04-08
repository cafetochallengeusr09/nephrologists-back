package com.challenge.nephrologistBaseClinic.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.nephrologistBaseClinic.model.NephrologistBaseClinic;
import com.challenge.nephrologistBaseClinic.service.NephrologistBaseClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_NEPHROLOGIST_BASE_CLINIC)
@Lazy
public class NephrologistBaseClinicController extends ControllerBase<NephrologistBaseClinic> {

    @Autowired
    public NephrologistBaseClinicController(NephrologistBaseClinicService service) {
        super(service);
    }
}
