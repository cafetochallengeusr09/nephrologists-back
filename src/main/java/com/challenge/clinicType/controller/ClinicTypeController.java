package com.challenge.clinicType.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.clinicType.model.ClinicType;
import com.challenge.clinicType.service.ClinicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_CLINIC_TYPE)
@Lazy
public class ClinicTypeController extends ControllerBase<ClinicType> {

    @Autowired
    public ClinicTypeController(ClinicTypeService service) {
        super(service);
    }
}
