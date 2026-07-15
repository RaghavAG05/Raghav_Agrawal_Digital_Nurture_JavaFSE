package org.raghav.findcountry;

import org.raghav.findcountry.model.Country;
import org.raghav.findcountry.service.CountryService;
import org.raghav.findcountry.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FindCountryApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindCountryApplication.class);

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        FindCountryApplication.class,
                        args
                );

        CountryService countryService =
                context.getBean(CountryService.class);

        testFindCountryByCode(countryService);
    }

    private static void testFindCountryByCode(
            CountryService countryService) {

        LOGGER.info("----- Find Country By Code -----");

        try {

            Country country =
                    countryService.findCountryByCode("IN");

            LOGGER.info("Country found: {}", country);

        } catch (CountryNotFoundException e) {

            LOGGER.error("{}", e.getMessage());
        }

        LOGGER.info("--------------------------------");
    }
}