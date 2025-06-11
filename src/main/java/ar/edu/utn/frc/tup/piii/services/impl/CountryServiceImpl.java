package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.models.Country;
import ar.edu.utn.frc.tup.piii.repositories.CountryRepository;

import ar.edu.utn.frc.tup.piii.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll().stream().map(
                e -> Country.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .neighbours(e.getAdjacentCountries().stream().map(
                                ne -> Country.builder()
                                        .id(ne.getId())
                                        .name(ne.getName())
                                        .neighbours(null)
                                        .build()
                        ).toList())
                        .build()
        ).toList();
    }


}
