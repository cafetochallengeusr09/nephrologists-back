package com.challenge.city.controller;

import com.challenge.api.commons.Constants;
import com.challenge.api.commons.ControllerBase;
import com.challenge.city.model.City;
import com.challenge.city.service.CityService;
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
