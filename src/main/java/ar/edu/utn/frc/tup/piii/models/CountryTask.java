package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.models.interfaces.Achievable;

import java.util.List;

public class CountryTask implements Achievable {
    private List<MatchCountry> targetCountries;
    private int ammount;

    public CountryTask(List<MatchCountry> targetCountries, int ammount){
        this.targetCountries = targetCountries;
        this.ammount = ammount;
    }


    public boolean isAchieved(Player player) {
        int conquered = 0;
        for (int i = 0; i < ammount; i++) {
            if(targetCountries.get(i).getOwner() == player){
                conquered++;
                if(conquered >= ammount) return true;
            }
        }
        return false;
    }

}
