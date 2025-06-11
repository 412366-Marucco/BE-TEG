package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.entities.CountryEntity;
import ar.edu.utn.frc.tup.piii.repositories.TestRepository;
import ar.edu.utn.frc.tup.piii.services.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;
    public TestServiceImpl(TestRepository testRepository){
        this.testRepository = testRepository;
    }
    @Override
    public List<CountryEntity> getAll() {
        return testRepository.findAll();
    }

    @Override
    public CountryEntity getById(Integer id) {
        return testRepository.getReferenceById(id);
    }


}
