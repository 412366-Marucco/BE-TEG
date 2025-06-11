package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.Color;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa a un jugador (humano o bot) en una partida de TEG.
 * Gestiona objetivos, cartas, países bajo control, canjes de cartas, tropas a agregar y eliminación.
 * Controla la lógica para que una tropa solo pueda moverse una vez por turno.
 * Métodos abstractos: requestCard, pass.
 */
@Data
public abstract class Player {
    private final Integer id;
    private String name;
    private final Color color;
    private List<Objective> objectives;
    private Player defeatedBy;
    private List<Card> cards;
    private Integer troopsToAdd;
    private Integer numberOfExchanges;
    private List<MatchCountry> matchCountries;

    /**
     * Constructor principal del jugador.
     * @param id Identificador único del jugador.
     * @param name Nombre del jugador.
     * @param color Color asignado al jugador.
     * @param objectives Lista inicial de objetivos (puede ser vacía o null).
     */
    public Player(Integer id, String name, Color color, List<Objective> objectives) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.objectives = (objectives != null) ? objectives : new ArrayList<>();
        this.cards = new ArrayList<>();
        this.matchCountries = new ArrayList<>();
        this.defeatedBy = null;
        this.troopsToAdd = 0;
        this.numberOfExchanges = 0;
    }

    /**
     * Realiza un ataque desde un país propio a un país vecino.
     * Valida propietario, cantidad de tropas y vecindad.
     * @param attacker País atacante (debe ser propio y tener más de 1 tropa).
     * @param defender País objetivo (debe ser vecino).
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void attack(MatchCountry attacker, MatchCountry defender) {
        if (!attacker.getOwner().equals(this)) {
            throw new IllegalArgumentException("No puedes atacar con un país que no te pertenece.");
        }
        if (attacker.getTroops() <= 1) {
            throw new IllegalArgumentException("Necesitas más de una tropa para atacar.");
        }
        if (!attacker.getNeighbours().contains(defender)) {
            throw new IllegalArgumentException("Solo puedes atacar países vecinos.");
        }
        attacker.attack(defender);
    }

    /**
     * Reagrupa tropas entre dos países propios que sean vecinos.
     * Solo puede mover tropas que no hayan sido movidas previamente en el turno actual.
     * Las tropas movidas no pueden volver a moverse en el mismo turno.
     * @param origin País de origen (debe ser propio y tener tropas suficientes).
     * @param target País destino (debe ser propio y vecino del origen).
     * @param amount Cantidad de tropas a mover.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void regroupArmy(MatchCountry origin, MatchCountry target, Integer amount) {
        if (!origin.getOwner().equals(this) || !target.getOwner().equals(this)) {
            throw new IllegalArgumentException("Ambos países deben pertenecerte.");
        }
        if (!origin.getNeighbours().contains(target)) {
            throw new IllegalArgumentException("Los países deben ser vecinos para reagrupar.");
        }
        // Solo pueden moverse las tropas originales que no hayan sido movidas este turno
        int movable = origin.getTroops() - origin.getMovedTroopsThisTurn();
        if (amount > movable) {
            throw new IllegalArgumentException("No puedes mover más tropas de las que no hayan sido movidas este turno.");
        }
        origin.receiveDamage(amount);
        origin.addMovedTroopsThisTurn(amount);
        target.addTroops(amount);
        target.addMovedTroopsThisTurn(amount); // Las tropas que llegan no pueden volver a moverse en este turno
    }

    /**
     * Agrega tropas a un país propio. Las tropas agregadas NO podrán moverse en este turno.
     * @param target País objetivo.
     * @param amount Cantidad de tropas a agregar.
     */
    public void addTroops(MatchCountry target, Integer amount) {
        target.setOwner(this);
        target.addTroops(amount);
        target.addMovedTroopsThisTurn(amount); // Así las tropas nuevas no pueden reagruparse este turno
    }

    /**
     * Metodo abstracto: define cómo solicita una carta el jugador.
     */
    public abstract void requestCard();

    /**
     * Metodo abstracto: define la acción de pasar turno.
     */
    public abstract void pass();

    /**
     * Agrega un objetivo a la lista del jugador.
     * @param objective Objetivo a agregar.
     */
    public void addObjective(Objective objective) {
        this.objectives.add(objective);
    }

    /**
     * Agrega una carta a la mano del jugador.
     * @param card Carta a agregar.
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Lógica común para canje de cartas: valida, elimina y suma tropas.
     * Las subclases llaman a este método pasando el set elegido.
     * @param cardsToExchange Lista de 3 cartas a canjear.
     */
    public void exchangeCards(List<Card> cardsToExchange) {
        if (cardsToExchange == null || cardsToExchange.size() != 3) {
            throw new IllegalArgumentException("Debes seleccionar exactamente 3 cartas para canjear.");
        }
        for (Card card : cardsToExchange) {
            if (!this.getCards().contains(card)) {
                throw new IllegalArgumentException("No tienes la carta: " + card);
            }
        }
        if (!isValidSetForExchange(cardsToExchange)) {
            throw new IllegalArgumentException("El set de cartas no es válido para canje.");
        }
        this.getCards().removeAll(cardsToExchange);
        this.setTroopsToAdd(this.getTroopsToAdd() + calculateTroopsToAdd());
        this.setNumberOfExchanges(this.getNumberOfExchanges() + 1);
    }

    /**
     * Calcula la cantidad de tropas a agregar por el próximo canje de cartas.
     * @return Cantidad de tropas a agregar.
     */
    public Integer calculateTroopsToAdd(){
        switch (this.numberOfExchanges){
            case 0: return 4;
            case 1: return 7;
            case 2: return 10;
            default: return (numberOfExchanges - 2) * 5 + 10;
        }
    }

    /**
     * Verifica si un set de 3 cartas es válido para canje.
     * Permite comodines (JOKER) según reglas estándar de TEG/Risk.
     * @param cards Lista de 3 cartas.
     * @return true si es un set válido, false en caso contrario.
     */
    protected boolean isValidSetForExchange(List<Card> cards) {
        if (cards.size() != 3) return false;

        int cannons = 0, balloons = 0, galleons = 0, jokers = 0;
        for (Card card : cards) {
            switch (card.getType()) {
                case CANNON -> cannons++;
                case BALLOON -> balloons++;
                case GALLEON -> galleons++;
                case JOKER -> jokers++;
            }
        }

        // 3 iguales (con comodines)
        if (cannons + jokers >= 3 || balloons + jokers >= 3 || galleons + jokers >= 3) return true;

        // Uno de cada tipo (con comodines)
        int uniqueTypes = 0;
        if (cannons > 0) uniqueTypes++;
        if (balloons > 0) uniqueTypes++;
        if (galleons > 0) uniqueTypes++;

        return (uniqueTypes + jokers) >= 3;
    }

    /**
     * Agrega un país a la lista de países controlados por el jugador.
     * @param country País a agregar.
     */
    public void addMatchCountry(MatchCountry country) {
        this.matchCountries.add(country);
    }

    /**
     * Elimina un país de la lista de países controlados por el jugador.
     * @param country País a eliminar.
     */
    public void removeMatchCountry(MatchCountry country) {
        this.matchCountries.remove(country);
    }

    /**
     * Resetea el contador de tropas movidas en cada país para un nuevo turno.
     * Se debe llamar al inicio del turno del jugador.
     */
    public void resetMovedTroopsThisTurn() {
        for (MatchCountry country : matchCountries) {
            country.resetMovedTroopsThisTurn();
        }
    }
}