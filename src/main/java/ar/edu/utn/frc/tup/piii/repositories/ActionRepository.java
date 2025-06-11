package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.entities.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<ActionEntity, Integer> {
}
