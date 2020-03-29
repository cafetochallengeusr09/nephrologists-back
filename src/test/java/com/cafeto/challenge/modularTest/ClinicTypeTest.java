package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.clinicType.model.ClinicType;
import com.cafeto.challenge.clinicType.service.ClinicTypeService;
import com.cafeto.challenge.helper.CafetoMockBase;
import com.cafeto.challenge.helper.PerformMockMvcComponent;
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
public class ClinicTypeTest implements CafetoMockBase {

    private static final String URI = Constants.URI_CLINIC_TYPE;

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
        ClinicType model = new ClinicType();
        model.setDescription("DIÁLISIS PERITONEA");
        performMockMvcComponent.performAdd(URI, model);

        model = new ClinicType();
        model.setDescription("HEMODIÁLISIS");
        performMockMvcComponent.performAdd(URI, model);

        model = new ClinicType();
        model.setDescription("NEFROLOGÍA GENERAL");
        performMockMvcComponent.performAdd(URI, model);

        model = new ClinicType();
        model.setDescription("ENFERMEDADES SISTÉMICAS Y AUTOINMUNES");
        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        ClinicType model = clinicTypeService.findAll().get(0);
        model.setDescription("DIÁLISIS PERITONEA - EDIT");

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        ClinicType model = clinicTypeService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        ClinicType model = clinicTypeService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }

}