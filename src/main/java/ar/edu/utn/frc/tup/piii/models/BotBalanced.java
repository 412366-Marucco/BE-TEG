package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.models.interfaces.Profile;

import java.util.*;
import java.util.stream.Collectors;

public class BotBalanced extends Player implements Profile {

    public BotBalanced(Integer id, String name, ar.edu.utn.frc.tup.piii.enums.Color color, List<ar.edu.utn.frc.tup.piii.models.Objective> objectives) {
        super(id, name, color, objectives);
    }

    @Override
    public void calculateAttackPhase() {
        List<MatchCountry> attackableCountries = getMatchCountries().stream()
                .filter(c -> c.getTroops() > 1)
                .toList();

        for (MatchCountry attacker : attackableCountries) {
            List<MatchCountry> possibleTargets = attacker.getNeighbours().stream()
                    .filter(neighbour -> !neighbour.getOwner().equals(this) && attacker.getTroops() >= 2 * neighbour.getTroops())
                    .collect(Collectors.toList());

            // Si no hay países favorables para atacar, pasa sin atacar
            if (possibleTargets.isEmpty()) continue;

            // Prioriza los que estén dentro de su objetivo
            MatchCountry target = selectTarget(possibleTargets);

            // Ataca mientras mantenga una buena ventaja
            while (attacker.getTroops() > 1 && attacker.getTroops() >= 2 * target.getTroops()) {
                this.attack(attacker, target);
                if (target.getOwner().equals(this)) { // Si conquistó el país
                    // Mueve tropas pero deja al menos 2 en el original
                    int movableTroops = attacker.getTroops() - 2;
                    if (movableTroops > 0) {
                        this.regroupArmy(attacker, target, movableTroops);
                    }
                    break; // Solo mueve tropas a un territorio conquistado por ataque
                }
            }
        }
    }

    @Override
    public void calculateRegroupPhase() {
        List<MatchCountry> myCountries = getMatchCountries();

        // Mueve tropas desde territorios seguros hacia fronteras
        for (MatchCountry origin : myCountries) {
            if (isSafeTerritory(origin)) {
                for (MatchCountry neighbour : origin.getNeighbours()) {
                    if (neighbour.getOwner().equals(this) && isBorderCountry(neighbour)) {
                        int movableTroops = origin.getTroops() - origin.getMovedTroopsThisTurn() - 1;
                        if (movableTroops > 0) {
                            this.regroupArmy(origin, neighbour, movableTroops);
                        }
                    }
                }
            }
        }

        // Mueve tropas desde territorios aislados con tropas en exceso hacia territorios útiles
        for (MatchCountry origin : myCountries) {
            if (origin.getTroops() > 2 && isIsolated(origin)) {
                Optional<MatchCountry> possibleTarget = origin.getNeighbours().stream()
                        .filter(n -> n.getOwner().equals(this))
                        .findFirst();
                possibleTarget.ifPresent(target -> {
                    int movableTroops = origin.getTroops() - origin.getMovedTroopsThisTurn() - 1;
                    if (movableTroops > 0) {
                        this.regroupArmy(origin, target, movableTroops);
                    }
                });
            }
        }
    }

    @Override
    public void calculateExchangePhase() {
        // Implementa el canje si hay al menos 3 cartas y si es necesario reforzar tropas
        if (getCards().size() >= 3) {
            List<List<ar.edu.utn.frc.tup.piii.models.Card>> possibleExchanges = findPossibleExchanges();
            if (!possibleExchanges.isEmpty()) {
                exchangeCards(possibleExchanges.get(0)); // Realiza el primer canje válido
            }
        }
    }

    @Override
    public void requestCard() {
        // No hace nada por ahora
    }

    @Override
    public void pass() {
        // No hace nada por ahora
    }

    private MatchCountry selectTarget(List<MatchCountry> possibleTargets) {
        // Prioriza países que estén en su objetivo
        for (MatchCountry target : possibleTargets) {
            if (isObjectiveCountry(target)) {
                return target;
            }
        }
        // Si no hay países de objetivo, elige el que tenga menos tropas
        return possibleTargets.stream().min(Comparator.comparingInt(MatchCountry::getTroops)).orElse(possibleTargets.get(0));
    }

    private boolean isObjectiveCountry(MatchCountry country) {
        List<Objective> objectives = this.getObjectives();

        for (Objective objective : objectives) {
            List<Objective> targetCountries = objective.getPlayer().getObjectives();
            if (targetCountries != null && targetCountries.contains(country.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSafeTerritory(MatchCountry country) {
        // Un país es seguro si todos sus vecinos también son del mismo jugador
        return country.getNeighbours().stream().allMatch(neighbour -> neighbour.getOwner().equals(this));
    }

    private boolean isBorderCountry(MatchCountry country) {
        // Un país frontera tiene al menos un vecino enemigo
        return country.getNeighbours().stream().anyMatch(neighbour -> !neighbour.getOwner().equals(this));
    }

    private boolean isIsolated(MatchCountry country) {
        // Consideramos aislado si tiene tropas de sobra y no está en contacto con enemigos
        return !isBorderCountry(country);
    }

    private List<List<ar.edu.utn.frc.tup.piii.models.Card>> findPossibleExchanges() {
        List<ar.edu.utn.frc.tup.piii.models.Card> cards = getCards();
        List<List<ar.edu.utn.frc.tup.piii.models.Card>> combinations = new ArrayList<>();

        // Genera todas las combinaciones de 3 cartas posibles
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    List<ar.edu.utn.frc.tup.piii.models.Card> set = Arrays.asList(cards.get(i), cards.get(j), cards.get(k));
                    if (isValidSetForExchange(set)) {
                        combinations.add(set);
                    }
                }
            }
        }
        return combinations;
    }
}
