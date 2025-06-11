package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "objectives")
public class ObjectiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "objectives_continent_targets",
            joinColumns = {@JoinColumn(name = "id_objective")},
            inverseJoinColumns = {@JoinColumn(name = "id_continent_target")}
    )
    private List<ContinentTargetEntity> continentTargets;
    @ManyToOne
    private ObjectiveTypeEntity objectiveType;
    @ManyToOne
    private ColorEntity targetColor;
    private Integer targetAdjacentCountries;
    private Integer targetCountries;
}
