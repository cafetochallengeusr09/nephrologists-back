package com.challenge.zone.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.zone.model.Zone;
import com.challenge.zone.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_ZONE)
@Lazy
public class ZoneController extends ControllerBase<Zone> {

    @Autowired
    public ZoneController(ZoneService service) {
        super(service);
    }
}
