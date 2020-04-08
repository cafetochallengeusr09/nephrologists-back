package com.challenge.modularTest;

import com.challenge.api.commons.Constants;
import com.challenge.city.model.City;
import com.challenge.city.service.CityService;
import com.challenge.helper.ChallengeMockBase;
import com.challenge.helper.PerformMockMvcComponent;
import com.challenge.zone.model.Zone;
import com.challenge.zone.service.ZoneService;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource")
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Disabled
public class CityTest implements ChallengeMockBase {

    private static final String URI = Constants.URI_CITY;

    @Autowired
    CityService cityService;
    @Autowired
    ZoneService zoneService;
    @Autowired
    PerformMockMvcComponent performMockMvcComponent;

    @Test
    @Override
    public void runAllCases() throws Exception {
        add();
        edit();
        findAll();
        findOne();
        delete();
    }

    public void add() throws Exception {
        List<Zone> zones = zoneService.findAll();

        Zone zone = zones.get(0);

        City model = new City();
        model.setDescription("BOGOTA");
        model.setZone(zone);
        performMockMvcComponent.performAdd(URI, model);

        zone = zones.get(1);

        model = new City();
        model.setDescription("CALI");
        model.setZone(zone);
        performMockMvcComponent.performAdd(URI, model);

        zone = zones.get(2);

        model = new City();
        model.setDescription("MEDELLIN");
        model.setZone(zone);
        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        City model = cityService.findAll().get(0);
        model.setDescription("CENTRO-EDIT");

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        City model = cityService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        City model = cityService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }
}
