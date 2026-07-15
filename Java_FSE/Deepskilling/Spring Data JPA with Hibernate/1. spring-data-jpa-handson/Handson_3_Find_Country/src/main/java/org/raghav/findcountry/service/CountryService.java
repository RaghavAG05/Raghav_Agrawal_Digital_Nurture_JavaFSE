package org.raghav.findcountry.service;

import org.raghav.findcountry.model.Country;
import org.raghav.findcountry.repository.CountryRepository;
import org.raghav.findcountry.service.exception.CountryNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result =
                countryRepository.findById(countryCode);

        if (result.isEmpty()) {
            throw new CountryNotFoundException(
                    "Country not found with code: " + countryCode
            );
        }

        return result.get();
    }
}