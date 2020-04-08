package com.challenge.modularTest;

import com.challenge.api.commons.Constants;
import com.challenge.city.model.City;
import com.challenge.city.service.CityService;
import com.challenge.clinic.model.Clinic;
import com.challenge.clinic.service.ClinicService;
import com.challenge.clinicType.model.ClinicType;
import com.challenge.clinicType.service.ClinicTypeService;
import com.challenge.helper.ChallengeMockBase;
import com.challenge.helper.PerformMockMvcComponent;
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
public class ClinicTest implements ChallengeMockBase {

    private static final String URI = Constants.URI_CLINIC;

    @Autowired
    ClinicService clinicService;
    @Autowired
    CityService cityService;
    @Autowired
    ClinicTypeService clinicTypeService;
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
        clinicService.deleteAll();

        List<ClinicType> clinicTypes = clinicTypeService.findAll();
        List<City> cities = cityService.findAll();

        ClinicType clinicType = clinicTypes.get(0);
        City city = cities.get(0);

        Clinic model = new Clinic();
        model.setName("USA Nephrology Specialists");
        model.setDirector("Dr. Marck Beckner");
        model.setEmail("USA-Nephrology-Specialists@USANS.com");
        model.setAdministrator("Dr. Shanne Velovsky");
        model.setCapacity(3000L);
        model.setCity(city);
        model.setClinicType(clinicType);

        performMockMvcComponent.performAdd(URI, model);

        clinicType = clinicTypes.get(1);
        city = cities.get(1);

        model = new Clinic();
        model.setName("Johns Hopkins Hospital");
        model.setDirector("Dr. Christopher J. Abularrage, MD");
        model.setEmail("EEOconcerns@jhmi.edu");
        model.setAdministrator("Dr. James H. Black, MD");
        model.setCapacity(6000L);
        model.setCity(city);
        model.setClinicType(clinicType);

        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        Clinic model = clinicService.findAll().get(0);
        model.setName(model.getName() + " - EDIT");

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        Clinic model = clinicService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        Clinic model = clinicService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }


}
