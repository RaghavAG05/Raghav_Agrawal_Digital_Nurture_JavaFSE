package org.raghav.querymethods.service;

import org.raghav.querymethods.model.Country;
import org.raghav.querymethods.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public List<Country> searchByContainingText(String text) {
        return countryRepository.findByNameContainingIgnoreCase(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchByContainingTextSorted(String text) {
        return countryRepository
                .findByNameContainingIgnoreCaseOrderByNameAsc(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchByStartingText(String text) {
        return countryRepository.findByNameStartingWithIgnoreCase(text);
    }

    @Transactional(readOnly = true)
    public List<Country> searchByStartingTextSorted(String text) {
        return countryRepository
                .findByNameStartingWithIgnoreCaseOrderByNameAsc(text);
    }
}