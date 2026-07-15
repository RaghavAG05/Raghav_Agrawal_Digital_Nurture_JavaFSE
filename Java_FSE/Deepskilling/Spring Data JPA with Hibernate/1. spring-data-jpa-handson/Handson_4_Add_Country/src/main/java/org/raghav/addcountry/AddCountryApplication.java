package org.raghav.addcountry;

import org.raghav.addcountry.model.Country;
import org.raghav.addcountry.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AddCountryApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AddCountryApplication.class);

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        AddCountryApplication.class,
                        args
                );

        CountryService countryService =
                context.getBean(CountryService.class);

        testAddCountry(countryService);
    }

    private static void testAddCountry(
            CountryService countryService) {

        LOGGER.info("----- Add New Country -----");

        Country country = new Country("FR", "FRANCE");

        Country savedCountry =
                countryService.addCountry(country);

        LOGGER.info("Country added successfully: {}", savedCountry);

        LOGGER.info("---------------------------");
    }
}