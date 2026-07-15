package org.raghav.querymethods.repository;

import org.raghav.querymethods.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository
        extends JpaRepository<Country, String> {

    // Search where country name contains given text
    List<Country> findByNameContainingIgnoreCase(String text);

    // Search where name contains text and sort ascending by name
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    // Search where country name starts with given text
    List<Country> findByNameStartingWithIgnoreCase(String text);

    // Search where country name starts with text and sort ascending
    List<Country> findByNameStartingWithIgnoreCaseOrderByNameAsc(String text);
}