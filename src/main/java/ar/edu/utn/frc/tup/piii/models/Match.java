package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.CardType;
import ar.edu.utn.frc.tup.piii.enums.MatchState;
import ar.edu.utn.frc.tup.piii.enums.TurnPhase;
import ar.edu.utn.frc.tup.piii.enums.Vote;
import ar.edu.utn.frc.tup.piii.models.interfaces.Achievable;
import ar.edu.utn.frc.tup.piii.utils.Graph;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.*;

/**
 * Representa una partida de TEG.
 * Gestiona el estado de la partida, jugadores, países, cartas, objetivos y el registro de acciones.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {
    private int id;
    private MatchState state;
    private Player winner;
    private List<Player> players;
    private Duration turnTimer;
    private TurnPhase turnPhase;
    private List<MatchCountry> countries;
    private Player currentPlayer;
    private Stack<Card> cards;
    private List<Objective> objectives;
    private boolean isFirstRound;
    private List<Message> messages = new ArrayList<>();
    private Logger logger = new Logger();
    private List<Action> actions = new ArrayList<>();
    private Graph<MatchCountry> countryGraph;
    private Map<Player, Vote> votes = new HashMap<>();

    /**
     * Constructor principal. Inicializa la partida con la lista de jugadores.
     * @param players lista de jugadores que participan en la partida.
     */
    public Match(List<Player> players){
        this.id = 0;
        this.logger = new Logger();
        this.state = MatchState.IN_PROGRESS;
        this.winner = null;
        this.players = players;
        this.messages = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.votes = new HashMap<>();
        this.isFirstRound = true;
    }

    /**
     * Registra el voto de un jugador y verifica si hay mayoría para pausar, reanudar o finalizar la partida.
     * @param player Jugador que emite el voto.
     * @param vote Tipo de voto emitido.
     */
    public void setVote(Player player, Vote vote){
        votes.put(player, vote);
        verifyVotes();
    }

    /**
     * Verifica si hay mayoría de votos para pausar, reanudar o finalizar la partida.
     * Cambia el estado de la partida y registra la acción en el logger usando la fase actual.
     */
    private void verifyVotes() {
        if (votes.size() == players.size()) {
            int pauseCounter = 0;
            int resumeCounter = 0;
            int endCounter = 0;

            for (Vote vote : votes.values()) {
                if (vote == Vote.PAUSE_MATCH) pauseCounter++;
                else if (vote == Vote.RESUME_MATCH) resumeCounter++;
                else if (vote == Vote.END_MATCH) endCounter++;
            }

            int totalPlayers = players.size();

            if (pauseCounter > totalPlayers / 2) {
                state = MatchState.PAUSED;
                logger.addAction(new Action(null, this.turnPhase, null, new HashSet<>(players), null));
            } else if (resumeCounter > totalPlayers / 2) {
                state = MatchState.IN_PROGRESS;
                logger.addAction(new Action(null, this.turnPhase, null, new HashSet<>(players), null));
            } else if (endCounter > totalPlayers / 2) {
                state = MatchState.FINISHED;
                logger.addAction(new Action(null, this.turnPhase, null, new HashSet<>(players), null));
            }

            votes.clear();
        }
    }

    /**
     * Devuelve un resumen de la partida como cadena de texto.
     * @return Resumen de la partida.
     */
    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", players=" + players +
                ", logger=" + logger +
                ", state=" + state +
                ", winner=" + winner +
                '}';
    }

    /**
     * Asigna aleatoriamente el orden de los jugadores.
     * Registra la acción en logger como SETUP.
     */
    public void assignPlayOrder() {
        Collections.shuffle(players);
        logger.addAction(new Action(null, TurnPhase.SETUP, null, new HashSet<>(players), null));
    }

    /**
     * Asigna los países de la partida a los jugadores de forma equitativa.
     * Registra cada asignación en logger como SETUP.
     */
    public void assignCountries() {
        for (int i = 0; i < countries.size(); i++) {
            Player owner = players.get(i % players.size());
            MatchCountry country = countries.get(i);
            country.setOwner(owner);
            logger.addAction(new Action(null, TurnPhase.SETUP, null, Set.of(owner), Set.of(country)));
        }
    }

    /**
     * Asigna los objetivos a los jugadores.
     * Todos reciben el objetivo general (primero en la lista) y luego un objetivo secreto (si hay suficientes).
     * Registra cada asignación en logger como SETUP.
     */
    public void assignObjectives(){
        List<Achievable> achievables = new ArrayList<>( );

        CountryTask occupyThirtyCountries = new CountryTask(countries, 30);
        achievables.add(occupyThirtyCountries);
        Stack<Objective> objectiveStack = new Stack<>();
        objectiveStack.addAll(objectives);
        Collections.shuffle(objectiveStack);

        for(Player player : players){
            Objective generalObjective = objectives.get(0);
            player.addObjective(generalObjective);
            player.addObjective(objectiveStack.pop());

        }
    }

    /**
     * Inicializa a los jugadores y los elementos iniciales de la partida:
     * - Orden de juego
     * - Asignación de países
     * - Asignación de objetivos
     */
    public void initializePlayers() {
        assignPlayOrder();
        assignCountries();
        assignObjectives();
    }

    /**
     * Entrega una carta al jugador indicado.
     * Solo entrega si hay cartas disponibles; registra la acción en logger con la fase actual.
     * @param player Jugador que recibe la carta.
     */
    public void giveCard(Player player){
        if (cards != null && !cards.isEmpty()) {
            Card given = this.cards.pop();
            player.addCard(given);
            logger.addAction(new Action(null, this.turnPhase, null, Set.of(player), null));
        }
    }


    public void checkObjectives(){
        for(Objective objective : objectives){
            if(objective.isAchieved()){
                this.winner = objective.getPlayer();
                break;

            }
        }
    }

    /**
     * Verifica si algún jugador cumplió algún objetivo.
     * Si un jugador gana, se asigna como ganador, termina la partida y registra la acción usando la fase actual.
     */
//    public void checkObjectives() {
//        for (Player player : players) {
//            for (Objective obj : player.getObjectives()) {
//                if (obj.isAchieved()) {
//                    this.winner = player;
//                    this.state = MatchState.FINISHED;
//                    logger.addAction(new Action(null, this.turnPhase, null, Set.of(player), null));
//                    return;
//                }
//            }
//        }
//    }

    /**
     * Inicializa las cartas del mazo.
     * Crea una carta por país, alternando tipos de carta.
     * Mezcla el mazo y registra la acción en logger como SETUP.
     */
    public void initCards() {
        Stack<Card> cards = new Stack<>();
        CardType[] types = CardType.values();

        for (int i = 0; i < this.countries.size(); i++) {
            cards.add(new Card(types[i % types.length], countries.get(i)));
        }

        Collections.shuffle(cards);

        this.cards = cards;
        logger.addAction(new Action(null, TurnPhase.SETUP, null, null, null));
    }

    /**
     * Finaliza el turno del jugador actual y pasa el turno al siguiente jugador de la lista.
     * Reinicia el contador de tropas movidas para el siguiente jugador.
     */
    public void endPlayerTurn(Player player) {
        if (currentPlayer == null || !currentPlayer.equals(player)) {
            throw new IllegalStateException("No es el turno de este jugador.");
        }
        int playerIndex = players.indexOf(currentPlayer);
        if (playerIndex == -1) {
            throw new IllegalStateException("El jugador actual no se encuentra en la lista de jugadores.");
        }
        int nextPlayerIndex = (playerIndex + 1) % players.size();
        currentPlayer = players.get(nextPlayerIndex);

        // IMPORTANTE: Resetea los movimientos del nuevo jugador
        currentPlayer.resetMovedTroopsThisTurn();

        logger.addAction(new Action(
                null,
                this.turnPhase,
                null,
                Set.of(player),
                null
        ));
    }
}
