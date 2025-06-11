package ar.edu.utn.frc.tup.piii.dtos;

import ar.edu.utn.frc.tup.piii.enums.MatchState;
import ar.edu.utn.frc.tup.piii.enums.TurnPhase;
import ar.edu.utn.frc.tup.piii.models.*;
import ar.edu.utn.frc.tup.piii.utils.Graph;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDto {

    private int id;

    private List<Player> players;
    private Player currentPlayer;
    private Duration turnTimer;
    private TurnPhase turnPhase;

    private List<MatchCountry> countries;
    private Stack<Card> cards;
    private List<Objective> objectives;
    private Player winner;
    private boolean isFirstRound;
    private Graph<MatchCountry> countryGraph;
    private Logger logger;
    private MatchState state;
    private static Map<Player,Boolean> votes;

}
