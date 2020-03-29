package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.helper.HttpMockMvcComponent;
import com.cafeto.challenge.zone.model.Zone;
import com.cafeto.challenge.zone.service.ZoneService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Disabled
public class ZoneTest {

    private static final String URI = Constants.URI_ZONE;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ZoneService zoneService;

    @Autowired
    HttpMockMvcComponent mvcComponent;

    @Test
    public void runAllCases() throws Exception {
        add();
        edit();
        findAll();
        findOne();
        delete();
    }

    public void add() throws Exception {
        Zone model = new Zone();
        model.setDescription("CENTRO");
        performAdd(model);

        model = new Zone();
        model.setDescription("OCCIDENTE");
        performAdd(model);

        model = new Zone();
        model.setDescription("NORTE");
        performAdd(model);

        model = new Zone();
        model.setDescription("SUR");
        performAdd(model);
    }

    public void edit() throws Exception {
        Zone model = zoneService.findAll().get(0);
        model.setDescription("CENTRO-EDIT");

        performEdit(model);
    }

    public void findAll() throws Exception {
        performGetAll();
    }

    public void findOne() throws Exception {
        Zone model = zoneService.findAll().get(0);
        performGetOne(model.getId());
    }

    public void delete() throws Exception {
        Zone model = zoneService.findAll().get(0);
        performDelete(model.getId());
    }

    private void performAdd(Zone model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.post(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetAll() throws Exception {
        mockMvc.perform(mvcComponent.getAll(URI))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetOne(Long id) throws Exception {
        mockMvc.perform(mvcComponent.getById(URI, id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performEdit(Zone model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.put(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performDelete(Long id) throws Exception {
        mockMvc.perform(mvcComponent.delete(URI, id))
                .andExpect(status().isOk());
    }
}
