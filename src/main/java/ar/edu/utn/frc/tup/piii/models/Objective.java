package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.models.interfaces.Achievable;

import java.util.List;

public class Objective  {
    private List<Achievable> objectives;
    private Player player;

    public Objective(List<Achievable> objectives, Player player){

    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAchieved(){
        for(Achievable objective : objectives){
            if(!objective.isAchieved(this.player)) return false;
        }
        return true;
    };

}
