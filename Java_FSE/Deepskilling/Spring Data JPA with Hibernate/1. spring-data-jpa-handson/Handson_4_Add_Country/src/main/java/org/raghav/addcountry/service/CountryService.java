package org.raghav.addcountry.service;

import org.raghav.addcountry.model.Country;
import org.raghav.addcountry.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
}