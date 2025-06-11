package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.Color;
import ar.edu.utn.frc.tup.piii.models.interfaces.Profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class BotNewie extends Player implements  Profile {

    private Random random = new Random();

    private Profile profile;

    public BotNewie(Integer id, String name, Color color, List<Objective> objectives) {
        super(id, name, color, objectives);
    }

    @Override
    public void calculateAttackPhase() {

        // Obtener todos los países del jugador con más de 1 tropa
        List<MatchCountry> attackableCountries = getMatchCountries().stream()
                .filter(mc -> mc.getOwner().equals(this) && mc.getTroops() > 1)
                .collect(Collectors.toList());

        // Mezclar los países para que el ataque no sea siempre en el mismo orden
        Collections.shuffle(attackableCountries);

        // Recorrer cada país
        for (MatchCountry attacker : attackableCountries) {

            // Buscar vecinos enemigos que tengan menos tropas que el atacante
            List<MatchCountry> enemyNeighbors = attacker.getNeighbours().stream()
                    .filter(neighbor -> !neighbor.getOwner().equals(this)
                            && attacker.getTroops() > neighbor.getTroops())
                    .collect(Collectors.toList());

            //Si tiene enemigos válidos para atacar
            if (!enemyNeighbors.isEmpty()) {
                // Elegir uno al azar
                MatchCountry target = enemyNeighbors.get(random.nextInt(enemyNeighbors.size()));

                // Atacar mientras tenga más de una tropa
                while (attacker.getTroops() > 1) {

                    // Guardar cantidad de tropas antes del ataque
                    int initialAttackerTroops = attacker.getTroops();

                    // Ejecutar ataque
                    this.attack(attacker, target);

                    // Si conquistó el territorio
                    if (target.getOwner().equals(this)) {
                        // Mover la mitad de las tropas
                        int troopsToMove = initialAttackerTroops / 2;
                        if (troopsToMove > 0) {
                            this.regroupArmy(attacker, target, troopsToMove);
                        }
                        break; // Pasar al siguiente país atacante
                    }

                    // Si en el ataque no conquistó, decidir si seguir atacando
                    if (!target.getOwner().equals(this) && !random.nextBoolean()) {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void calculateRegroupPhase() {

        List<MatchCountry> fromCountries = getMatchCountries().stream()
                .filter(mc -> mc.getTroops() > 1)
                .collect(Collectors.toList());

        Collections.shuffle(fromCountries);

        for (MatchCountry origin : fromCountries) {
            // Buscar países vecinos que también sean del bot
            List<MatchCountry> ownNeighbors = origin.getNeighbours().stream()
                    .filter(n -> n.getOwner().equals(this))
                    .collect(Collectors.toList());

            if (!ownNeighbors.isEmpty()) {
                // Elegir uno al azar como destino
                MatchCountry target = ownNeighbors.get(random.nextInt(ownNeighbors.size()));

                // Mover cantidad aleatoria
                int troopsToMove = random.nextInt(origin.getTroops() - 1) + 1;

                this.regroupArmy(origin, target, troopsToMove);

                break;
            }
        }
    }

    @Override
    public void requestCard() {
        // El metodo en Match giveCard(Player) se encarga de dar una carta automáticamente
        //  si el bot conquistó y se invoca desde la lógica del juego (no desde el jugador).
    }

    @Override
    public void calculateExchangePhase() {
        if (this.getCards().size() >= 5 || (this.getCards().size() >= 3 && random.nextBoolean())) {
            attemptExchangeCards();
        }
    }


    /**
     * Busca automáticamente un set válido de 3 cartas y realiza el canje.
     * Si no encuentra un set válido, no hace nada.
     */
    public void attemptExchangeCards() {
        List<Card> cards = new ArrayList<>(this.getCards());
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    List<Card> candidateSet = List.of(cards.get(i), cards.get(j), cards.get(k));
                    if (isValidSetForExchange(candidateSet)) {
                        this.exchangeCards(candidateSet); // Llama a la lógica común de Player
                        return;
                    }
                }
            }
        }
    }

    /**
     * El bot selecciona el set a canjear automáticamente, por lo general no necesita usar este método directamente.
     * Pero si por alguna razón se lo llaman con un set, usa la lógica común de Player.
     */
    @Override
    public void exchangeCards(List<Card> cardsToExchange) {
        super.exchangeCards(cardsToExchange);
    }

    @Override
    public void pass() {
        // Queda vacío
        // Este bot siempre intentará realizar acciones durante su turno
    }
}
