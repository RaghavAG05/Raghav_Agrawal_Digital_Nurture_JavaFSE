package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        LOGGER.info("Starting Spring Learn Application");

        SpringApplication.run(SpringLearnApplication.class, args);

        displayCountry();

        LOGGER.info("Spring Learn Application Started Successfully");
    }

    public static void displayCountry() {

        LOGGER.debug("START");

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country.xml")) {

            Country country = context.getBean("country", Country.class);

            LOGGER.debug("Country : {}", country);
            LOGGER.debug("Country Code : {}", country.getCode());
            LOGGER.debug("Country Name : {}", country.getName());
        }

        LOGGER.debug("END");
    }
}