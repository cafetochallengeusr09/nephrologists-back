package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.clinic.model.Clinic;
import com.cafeto.challenge.clinic.service.ClinicService;
import com.cafeto.challenge.helper.CafetoMockBase;
import com.cafeto.challenge.helper.PerformMockMvcComponent;
import com.cafeto.challenge.nephrologist.model.Nephrologist;
import com.cafeto.challenge.nephrologist.service.NephrologistService;
import com.cafeto.challenge.nephrologistBaseClinic.model.NephrologistBaseClinic;
import com.cafeto.challenge.nephrologistBaseClinic.service.NephrologistBaseClinicService;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Disabled
public class NephrologistBaseClinicTest implements CafetoMockBase {

    private static final String URI = Constants.URI_NEPHROLOGIST_BASE_CLINIC;
    @Autowired
    NephrologistBaseClinicService nephrologistBaseClinicService;
    @Autowired
    NephrologistService nephrologistService;
    @Autowired
    ClinicService clinicService;
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
        List<Clinic> clinics = clinicService.findAll();
        List<Nephrologist> nephrologists = nephrologistService.findAll();

        Clinic clinic = clinics.get(0);
        Nephrologist nephrologist = nephrologists.get(0);

        NephrologistBaseClinic model = new NephrologistBaseClinic();
        model.setNephrologist(nephrologist);
        model.setClinic(clinic);
        model.setSalary(new BigDecimal(7500));
        model.setDedicationHours(48d);

        performMockMvcComponent.performAdd(URI, model);

        clinic = clinics.get(0);
        nephrologist = nephrologists.get(0);

        model = new NephrologistBaseClinic();
        model.setNephrologist(nephrologist);
        model.setClinic(clinic);
        model.setSalary(new BigDecimal(7500));
        model.setDedicationHours(32d);

        performMockMvcComponent.performAdd(URI, model);
    }

    public void edit() throws Exception {
        NephrologistBaseClinic model = nephrologistBaseClinicService.findAll().get(0);
        model.setDedicationHours(64d);

        performMockMvcComponent.performEdit(URI, model);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        NephrologistBaseClinic model = nephrologistBaseClinicService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        NephrologistBaseClinic model = nephrologistBaseClinicService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }

}