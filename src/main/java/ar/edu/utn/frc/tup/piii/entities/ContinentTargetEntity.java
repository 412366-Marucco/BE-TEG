package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "continent_targets")
public class ContinentTargetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ContinentEntity target;
    private Integer amount;
    @ManyToMany(mappedBy = "continentTargets")
    private List<ObjectiveEntity> objectives;
}
