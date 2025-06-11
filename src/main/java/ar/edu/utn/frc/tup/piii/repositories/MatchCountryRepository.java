package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.entities.MatchCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchCountryRepository extends JpaRepository<MatchCountryEntity, Integer> {
}
