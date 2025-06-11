package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.entities.CountryEntity;
import ar.edu.utn.frc.tup.piii.services.CountryService;
import ar.edu.utn.frc.tup.piii.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private CountryService countryService;

    @GetMapping("countries")
    public ResponseEntity<List<CountryEntity>> getAll(){
        return ResponseEntity.ok(testService.getAll());

    }
    @GetMapping("countries/{id}")
    public ResponseEntity<CountryEntity> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(testService.getById(id));

    }
}
