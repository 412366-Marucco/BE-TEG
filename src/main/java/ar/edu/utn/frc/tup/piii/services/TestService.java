package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.entities.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TestService {
    List<CountryEntity> getAll();
    CountryEntity getById(Integer id);
}
