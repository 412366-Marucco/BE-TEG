package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.Color;
import ar.edu.utn.frc.tup.piii.models.interfaces.Profile;

import java.util.List;


public class BotExpert extends Player implements Profile{
    private Profile profile;

    public BotExpert(Integer id, String name, Color color, List<Objective> objectives) {
        super(id, name, color, objectives);
    }

    @Override
    public void calculateAttackPhase() {

    }

    @Override
    public void calculateRegroupPhase() {

    }

    @Override
    public void calculateExchangePhase() {

    }

    @Override
    public void requestCard() {

    }

    @Override
    public void exchangeCards(List<Card> cardsToExchange) {
    }

    @Override
    public void pass() {

    }
}
