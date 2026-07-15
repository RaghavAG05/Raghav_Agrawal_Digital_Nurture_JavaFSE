package org.raghav.findcountry.repository;

import org.raghav.findcountry.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository
        extends JpaRepository<Country, String> {
}