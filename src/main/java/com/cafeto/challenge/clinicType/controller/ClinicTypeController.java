package com.cafeto.challenge.clinicType.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.clinicType.model.ClinicType;
import com.cafeto.challenge.clinicType.service.ClinicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_CLINIC_TYPE)
@Lazy
@CrossOrigin
public class ClinicTypeController extends ControllerBase<ClinicType> {

    @Autowired
    public ClinicTypeController(ClinicTypeService service) {
        super(service);
    }
}
