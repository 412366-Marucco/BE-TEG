package ar.edu.utn.frc.tup.piii.entities;

import ar.edu.utn.frc.tup.piii.enums.MatchState;
import ar.edu.utn.frc.tup.piii.enums.TurnPhase;
import ar.edu.utn.frc.tup.piii.models.*;
import ar.edu.utn.frc.tup.piii.utils.Graph;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MatchState state;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;

    @ManyToMany
    @JoinTable(
            name = "match_player",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<PlayerEntity> players = new ArrayList<>();



    private Integer turnTimer;

    @ManyToOne
    private TurnPhaseEntity turnPhase;

    @OneToMany
    private List<MatchCountryEntity> countries;
    @OneToMany
    private Stack<CardEntity> cards;

    private boolean isFirstRound;


    @OneToMany
    private List<MessageEntity> messages;

    @OneToMany
    private List<ActionEntity> actions;

}
