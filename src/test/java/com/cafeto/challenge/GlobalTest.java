package com.cafeto.challenge;

import com.cafeto.challenge.helper.CleanUpTest;
import com.cafeto.challenge.modularTest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Suite.SuiteClasses({
        CleanUpTest.class,
        UserTest.class,

        NephrologistTypeTest.class,
        NephrologistTest.class,

        ZoneTest.class,
        CityTest.class,
        ClinicTypeTest.class,

        ClinicTest.class,
        NephrologistBaseClinicTest.class
})
public class GlobalTest {
}
