package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.Color;
import ar.edu.utn.frc.tup.piii.enums.Vote;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Representa a un jugador humano en la partida.
 * Hereda toda la lógica base de Player y agrega interacción específica de usuario real.
 */
public class HumanPlayer extends Player {
    @Getter @Setter
    private Match match;

    /**
     * Constructor para crear un jugador humano.
     *
     * @param id         Identificador único del jugador.
     * @param name       Nombre del jugador.
     * @param color      Color asignado al jugador.
     * @param objectives Lista inicial de objetivos del jugador (puede ser vacía o null).
     */
    public HumanPlayer(Integer id, String name, Color color, List<Objective> objectives) {
        super(id, name, color, objectives);
    }

    /**
     * Permite al jugador emitir un voto general (pausa, reanuda, termina partida).
     * Usa el método de la instancia de Match asociada.
     *
     * @param vote tipo de voto a emitir.
     * @throws IllegalStateException si el jugador no está asociado a una partida.
     */
    public void vote(Vote vote) {
        if (match != null) {
            match.setVote(this, vote);
        } else {
            throw new IllegalStateException("No está asociada la partida (Match) en este jugador.");
        }
    }

    /**
     * El jugador abandona la partida eliminándose de la lista de jugadores.
     * No realiza acciones adicionales (como loguear o reasignar países).
     */
    public void leaveMatch() {
        if (match != null) {
            match.getPlayers().remove(this);
            this.match = null;
        }
    }

    /**
     * Implementación para solicitar una carta.
     * Delegada al Match, que gestiona el mazo y la entrega de cartas.
     */
    @Override
    public void requestCard() {
        if (match != null) {
            match.giveCard(this);
        }
    }

    @Override
    public void exchangeCards(List<Card> cardsToExchange) {
        super.exchangeCards(cardsToExchange);
    }

    /**
     * Finaliza el turno del jugador humano.
     * Notifica a la partida (Match) que este jugador terminó su turno, permitiendo avanzar al siguiente jugador
     * y cambiar el estado de la partida según corresponda.
     *
     * @throws IllegalStateException si el jugador no está asociado a una partida.
     */
    @Override
    public void pass() {
        if (match != null) {
            match.endPlayerTurn(this);
        } else {
            throw new IllegalStateException("No está asociada la partida (Match) en este jugador.");
        }
    }
}