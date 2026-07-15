package org.raghav.querymethods;

import org.raghav.querymethods.model.Country;
import org.raghav.querymethods.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class QueryMethodsApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(QueryMethodsApplication.class);

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        QueryMethodsApplication.class,
                        args
                );

        CountryService countryService =
                context.getBean(CountryService.class);

        testContainingText(countryService);
        testContainingTextSorted(countryService);
        testStartingText(countryService);
    }

    private static void testContainingText(
            CountryService countryService) {

        LOGGER.info("----- Countries containing 'ou' -----");

        List<Country> countries =
                countryService.searchByContainingText("ou");

        countries.forEach(country ->
                LOGGER.info("{}", country));

        LOGGER.info("-------------------------------------");
    }

    private static void testContainingTextSorted(
            CountryService countryService) {

        LOGGER.info(
                "----- Countries containing 'ou' sorted by name -----"
        );

        List<Country> countries =
                countryService.searchByContainingTextSorted("ou");

        countries.forEach(country ->
                LOGGER.info("{}", country));

        LOGGER.info("------------------------------------------------");
    }

    private static void testStartingText(
            CountryService countryService) {

        LOGGER.info("----- Countries starting with 'Z' -----");

        List<Country> countries =
                countryService.searchByStartingTextSorted("Z");

        countries.forEach(country ->
                LOGGER.info("{}", country));

        LOGGER.info("-----------------------------------------");
    }
}