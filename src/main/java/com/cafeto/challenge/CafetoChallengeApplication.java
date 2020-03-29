package com.cafeto.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author janezmejias.09
 * @version SPRINT-2020A
 * @see <url_jira_ticket_here>
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class CafetoChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafetoChallengeApplication.class, args);
    }

}
