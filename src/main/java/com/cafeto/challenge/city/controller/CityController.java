package com.cafeto.challenge.city.controller;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.api.commons.ControllerBase;
import com.cafeto.challenge.city.model.City;
import com.cafeto.challenge.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_CITY)
@Lazy
public class CityController extends ControllerBase<City> {

    @Autowired
    public CityController(CityService service) {
        super(service);
    }
}
