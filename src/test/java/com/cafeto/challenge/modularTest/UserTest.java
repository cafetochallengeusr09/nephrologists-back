package com.cafeto.challenge.modularTest;

import com.cafeto.challenge.api.commons.Constants;
import com.cafeto.challenge.helper.CafetoMockBase;
import com.cafeto.challenge.helper.PerformMockMvcComponent;
import com.cafeto.challenge.user.model.User;
import com.cafeto.challenge.user.service.UserService;
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
public class UserTest implements CafetoMockBase {

    private static final String URI = Constants.URI_USER;
    @Autowired
    UserService userService;
    @Autowired
    PerformMockMvcComponent performMockMvcComponent;

    @Test
    @Override
    public void runAllCases() throws Exception {
        add();
        findAll();
        findOne();
        delete();
    }

    public void add() throws Exception {
        User user = new User();
        user.setName("Juan");
        user.setEmail("janezmejias.09@gmail.com");
        user.setLogin("janezmejias");
        user.setPassword("Usr_DEV_2020-*");

        performMockMvcComponent.performAdd(URI, user);

        user = new User();
        user.setName("Carlos");
        user.setEmail("janezmejias.090@gmail.com");
        user.setLogin("janezmejias.090");
        user.setPassword("Usr_STG_2020-*");

        performMockMvcComponent.performAdd(URI, user);
    }

    public void findAll() throws Exception {
        performMockMvcComponent.performGetAll(URI);
    }

    public void findOne() throws Exception {
        User model = userService.findAll().get(0);
        performMockMvcComponent.performGetOne(URI, model.getId());
    }

    public void delete() throws Exception {
        User model = userService.findAll().get(0);
        performMockMvcComponent.performDelete(URI, model.getId());
    }

}
