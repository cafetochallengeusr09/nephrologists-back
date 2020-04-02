package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.helper.CafetoMockBase;
import com.cafeto.challenge.helper.PerformMockMvcComponent;
import com.cafeto.challenge.nephrologist.model.Nephrologist;
import com.cafeto.challenge.nephrologist.service.NephrologistService;
import com.cafeto.challenge.nephrologistType.model.NephrologistType;
import com.cafeto.challenge.nephrologistType.service.NephrologistTypeService;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource")
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Disabled
public class NephrologistTest implements CafetoMockBase {
    private static final String URI = Constants.URI_NEPHROLOGIST;

    @Autowired
    NephrologistService nephrologistService;
    @Autowired
    NephrologistTypeService nephrologistTypeService;
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
        NephrologistType nephrologistType = nephrologistTypeService.findAll().get(0);

        Nephrologist model = new Nephrologist();
        model.setName("Dr. Mario Magnone, MD");
        model.setEmail("mariomg@gmail.com");
        model.setActive(Boolean.TRUE);
        model.setNephrologistType(nephrologistType);

        performMockMvcComponent.performAdd(URI, model);

        nephrologistType = nephrologistTypeService.findAll().get(1);

        model = new Nephrologist();
        model.setName("Dr. Frank S. Pettyjohn, MD");
        model.setEmail("pettyjohn@gmail.com");
        model.setActive(Boolean.TRUE);
        model.setNephrologistType(nephrologistType);

        performMockMvcComponent.performAdd(URI, model);

        nephrologistType = nephrologistTypeService.findAll().get(0);

        model = new Nephrologist();
        model.setName("Dr. Jhon S. Jhon, MD");
        model.setEmail("jhon2two@gmail.com");
        model.setActive(Boolean.TRUE);
        model.setNephrologistType(nephrologistType);

        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        Nephrologist model = nephrologistService.findAll().get(0);
        model.setName(model.getName() + " - EDIT");

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        Nephrologist model = nephrologistService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        Nephrologist model = nephrologistService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }

}
