package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.ActionType;
import ar.edu.utn.frc.tup.piii.enums.TurnPhase;

import java.util.Set;


public class Action {
    private Integer Id;
    private String description;
    private String color;
    private final Integer turn;
    private final TurnPhase phase;
    private final ActionType type;
    private final Set<Player> players;
    private final Set<MatchCountry> countries;

    public Action(Integer turn, TurnPhase phase, ActionType type,
                  Set<Player> players, Set<MatchCountry> countries) {
        this.turn = turn;
        this.phase = phase;
        this.type = type;
        this.players = players;
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Turn " + turn +
                " | Fase: " + phase +
                " | Action: " + type +
                " | Players: " + players +
                " | Countries: " + countries;
    }
}
