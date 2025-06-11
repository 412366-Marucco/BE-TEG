package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Boolean isCurrentPlayer;

    @OneToMany
    private List<MatchObjectiveEntity> objectives;

    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private ColorEntity color;
    @ManyToOne
    private PlayerEntity defeatedBy;

    private Integer numberOfExchanges;
    private Integer troopsToAdd;
}
