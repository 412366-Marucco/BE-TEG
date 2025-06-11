package ar.edu.utn.frc.tup.piii.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Representa un país dentro de una partida (Match),
 * incluyendo su dueño, cantidad de tropas, estado y vecinos.
 * Controla el movimiento de tropas en el turno para evitar múltiples reagrupamientos de la misma tropa.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchCountry {
    private MatchCountryId id;
    private Match match;
    private Country country;
    private Player owner;
    private int troops;
    private boolean isDefeated;
    private int previousTroops;
    private List<MatchCountry> neighbours;
    private int movedTroopsThisTurn = 0;

    /**
     * Ejecuta un ataque contra un país defensor.
     * Realiza las tiradas, calcula el daño y transfiere propiedad si el defensor es derrotado.
     *
     * @param defendingCountry país que recibe el ataque
     */
    public void attack(MatchCountry defendingCountry) {
        Integer[] attackRolls = getRolls(true);
        int damageReceived = defendingCountry.defend(attackRolls);
        receiveDamage(damageReceived);
        if (defendingCountry.isDefeated) {
            defendingCountry.setOwner(this.owner);
            defendingCountry.isDefeated = false;
        }
    }

    /**
     * Defiende el país ante un ataque. Tira los dados de defensa, calcula el resultado del combate,
     * aplica el daño recibido y devuelve el daño infligido al atacante.
     *
     * @param attackRolls dados tirados por el atacante
     * @return cantidad de daño infligido al atacante
     */
    public int defend(Integer[] attackRolls){
        Integer[] defenseRolls = getRolls(false);

        BattleResult battleResult = getBattleResult(attackRolls,defenseRolls);

        int defenderDamage = battleResult.getDamageToDefender();
        int attackerDamage = battleResult.getDamageToAttacker();

        receiveDamage(defenderDamage);
        if(isDefeated) attackerDamage++;

        return attackerDamage;
    }

    /**
     * Aplica el daño recibido al país.
     * Si el daño iguala o supera las tropas, el país queda derrotado con 1 tropa restante.
     *
     * @param damage cantidad de daño recibido
     */
    public void receiveDamage(int damage){
        if(damage >= this.troops){
            isDefeated = true;
            this.troops = 1;
        }
        else{
            this.troops -= damage;
        }
    }

    /**
     * Calcula el resultado de un combate, comparando las tiradas de ataque y defensa.
     * Solo compara la cantidad mínima de dados entre ambos bandos.
     *
     * @param attackRolls dados del atacante (ordenados descendentemente)
     * @param defenseRolls dados del defensor (ordenados descendentemente)
     * @return objeto BattleResult con el daño a atacante y defensor
     */
    public BattleResult getBattleResult(Integer[] attackRolls, Integer[] defenseRolls) {
        BattleResult result = new BattleResult();

        int rounds = Math.min(attackRolls.length, defenseRolls.length);
        for (int i = 0; i < rounds; i++) {
            if (attackRolls[i] > defenseRolls[i]) {
                result.incrDamageToDefender();
            } else {
                result.incrDamageToAttacker();
            }
        }
        return result;
    }

    /**
     * Realiza las tiradas de dados para ataque o defensa.
     * Limita la cantidad de dados a las reglas del juego:
     * - Ataque: hasta 3 dados, pero nunca más que (tropas - 1)
     * - Defensa: hasta 3 dados, nunca más que las tropas disponibles
     *
     * @param isAttacking true si es tirada de ataque, false si es defensa
     * @return array de tiradas (ordenado descendentemente)
     */
    public Integer[] getRolls(boolean isAttacking){
        int nRolls;
        if (isAttacking) {
            nRolls = troops - 1;
            if (nRolls > 3) nRolls = 3;
        } else {
            nRolls = troops;
            if (nRolls > 3) nRolls = 3;
        }
        if (nRolls <= 0) return new Integer[0];

        Integer[] results = new Integer[nRolls];
        for (int i = 0; i < nRolls; i++) {
            results[i] = throwD6();
        }
        Arrays.sort(results, Collections.reverseOrder());

        return results;
    }

    /**
     * Simula la tirada de un dado de 6 caras.
     *
     * @return entero entre 1 y 6 inclusive
     */
    public int throwD6() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    /**
     * Agrega tropas al país y actualiza el registro de tropas anteriores.
     *
     * @param troopsToAdd cantidad de tropas a agregar
     */
    public void addTroops(int troopsToAdd){
        this.previousTroops = this.troops;
        this.troops += troopsToAdd;
    }

    /**
     * Mueve tropas fuera del país, validando que quede al menos una tropa,
     * que no supere las tropas originales, y que no muevas tropas ya movidas este turno.
     *
     * @param troopsToMove cantidad de tropas a mover
     * @return true si el movimiento fue posible, false si no
     */
    public boolean moveTroops(int troopsToMove){
        // Solo podés mover tropas que no hayan sido movidas este turno
        int movable = troops - movedTroopsThisTurn;
        if (troops - 1 >= troopsToMove && troopsToMove <= movable) {
            troops -= troopsToMove;
            movedTroopsThisTurn += troopsToMove;
            return true;
        }
        return false;
    }

    /**
     * Marca que llegaron nuevas tropas movidas este turno (por reagrupamiento).
     * @param amount Cantidad de tropas que llegaron (y quedan marcadas como movidas).
     */
    public void addMovedTroopsThisTurn(int amount) {
        this.movedTroopsThisTurn += amount;
    }

    /**
     * Resetea el contador de tropas movidas al iniciar el turno del jugador dueño.
     */
    public void resetMovedTroopsThisTurn() {
        this.movedTroopsThisTurn = 0;
    }

    /**
     * Devuelve el nombre del país base asociado a este MatchCountry.
     *
     * @return nombre del país, o null si no está definido
     */
    public String getName() {
        return country != null ? country.getName() : null;
    }


}