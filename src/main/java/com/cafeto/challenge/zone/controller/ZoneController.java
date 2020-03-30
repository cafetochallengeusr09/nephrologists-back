package com.cafeto.challenge.zone.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.zone.model.Zone;
import com.cafeto.challenge.zone.service.ZoneService;
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
