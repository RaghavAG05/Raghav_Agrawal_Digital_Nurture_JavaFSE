package org.raghav.countryservice;

import org.raghav.countryservice.model.Country;
import org.raghav.countryservice.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class CountryServiceApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryServiceApplication.class);

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        CountryServiceApplication.class,
                        args
                );

        CountryService countryService =
                context.getBean(CountryService.class);

        testCountryService(countryService);
    }

    private static void testCountryService(
            CountryService countryService) {

        LOGGER.info("----- Country Service Test -----");

        List<Country> countries =
                countryService.getAllCountries();

        countries.forEach(
                country -> LOGGER.info("{}", country)
        );

        LOGGER.info("Country service configured successfully.");
        LOGGER.info("--------------------------------");
    }
}