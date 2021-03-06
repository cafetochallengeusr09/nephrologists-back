package com.challenge.helper;

import com.challenge.city.repository.CityRepository;
import com.challenge.clinic.repository.ClinicRepository;
import com.challenge.clinicType.repository.ClinicTypeRepository;
import com.challenge.nephrologist.repository.NephrologistRepository;
import com.challenge.nephrologistBaseClinic.repository.NephrologistBaseClinicRepository;
import com.challenge.nephrologistType.repository.NephrologistTypeRepository;
import com.challenge.user.repository.UserRepository;
import com.challenge.zone.repository.ZoneRepository;
import org.junit.Test;
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
public class CleanUpTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NephrologistBaseClinicRepository nephrologistBaseClinicRepository;
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    ClinicTypeRepository clinicTypeRepository;
    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    NephrologistRepository nephrologistRepository;
    @Autowired
    NephrologistTypeRepository nephrologistTypeRepository;

    @Test
    public void clean() {
        userRepository.deleteAll();

        nephrologistBaseClinicRepository.deleteAll();
        clinicRepository.deleteAll();
        cityRepository.deleteAll();
        clinicTypeRepository.deleteAll();
        zoneRepository.deleteAll();

        nephrologistRepository.deleteAll();
        nephrologistTypeRepository.deleteAll();
    }
}
