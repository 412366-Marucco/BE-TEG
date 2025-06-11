package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.entities.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {
}
