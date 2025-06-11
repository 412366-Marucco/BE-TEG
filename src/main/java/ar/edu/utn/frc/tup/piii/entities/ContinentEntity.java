package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "continents")
public class ContinentEntity {
    @Id
    private int id;

    private String name;

    private int bonus;
}
