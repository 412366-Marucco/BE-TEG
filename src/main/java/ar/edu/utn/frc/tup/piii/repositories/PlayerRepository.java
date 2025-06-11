package ar.edu.utn.frc.tup.piii.repositories;

import ar.edu.utn.frc.tup.piii.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
}
