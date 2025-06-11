package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.models.interfaces.Achievable;

public class PlayerTask implements Achievable {
    private Player targetPlayer;

    @Override
    public boolean isAchieved(Player player) {
        return targetPlayer.getDefeatedBy() == player;
    }


}
