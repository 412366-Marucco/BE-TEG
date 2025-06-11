package ar.edu.utn.frc.tup.piii.models;

import java.util.Objects;

public class BattleResult {
    private int damageToAttacker;
    private int damageToDefender;

    public BattleResult(){
        this.damageToAttacker = 0;
        this.damageToDefender =0;
    }
    public int getDamageToDefender(){
        return damageToDefender;
    }
    public int getDamageToAttacker(){
        return damageToAttacker;
    }
    public void incrDamageToAttacker(){
        damageToAttacker++;
    }
    public void incrDamageToDefender(){
        damageToDefender++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BattleResult that = (BattleResult) o;
        return damageToAttacker == that.damageToAttacker && damageToDefender == that.damageToDefender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(damageToAttacker, damageToDefender);
    }




}
