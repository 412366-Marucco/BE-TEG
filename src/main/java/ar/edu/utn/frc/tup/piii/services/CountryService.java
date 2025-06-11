package ar.edu.utn.frc.tup.piii.services;


import ar.edu.utn.frc.tup.piii.models.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getAll();

}
