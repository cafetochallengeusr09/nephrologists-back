package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.helper.CafetoMockBase;
import com.cafeto.challenge.helper.PerformMockMvcComponent;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Disabled
public class NephrologistTypeTest implements CafetoMockBase {

    private static final String URI = Constants.URI_NEPHROLOGIST_TYPE;
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
        NephrologistType model = new NephrologistType();
        model.setDescription("Tubulointerstitial kidney diseases");

        performMockMvcComponent.performAdd(URI, model);

        model = new NephrologistType();
        model.setDescription("Electrolyte, fluid, and acid-base imbalances or disturbances");

        performMockMvcComponent.performAdd(URI, model);

        model = new NephrologistType();
        model.setDescription("Glomerular conditions, such as glomerulonephritis and nephrotic syndrome");

        performMockMvcComponent.performAdd(URI, model);

        model = new NephrologistType();
        model.setDescription("Advanced or chronic kidney disease");

        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        NephrologistType model = nephrologistTypeService.findAll().get(0);
        model.setDescription("Tubulointerstitial kidney diseases - EDITED");

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        NephrologistType model = nephrologistTypeService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        NephrologistType model = nephrologistTypeService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }

}
