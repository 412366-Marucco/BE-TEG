package ar.edu.utn.frc.tup.piii.models;

import ar.edu.utn.frc.tup.piii.enums.CardType;

public class Card {
    private final CardType type;
    private MatchCountry associatedCountry; // para type COUNTRY

    //private Objective associatedObjective; // para type OBJECTIVE

    public Card(CardType type, MatchCountry country){
        this.type = type;
        this.associatedCountry = country;
    }
    public CardType getType() {
        return type;
    }
    public MatchCountry getAssociatedCountry(){
        return associatedCountry;
    }
    /*
    // Constructor para cartas de país
    public Card(Country country) {
        this.type = CardType.COUNTRY;
        this.associatedCountry = country;
        this.associatedObjective = null;
    }

    // Constructor para cartas de objetivo
    public Card(Objective objective) {
        this.type = CardType.OBJECTIVE;
        this.associatedObjective = objective;
        this.associatedCountry = null;
    }

    // Constructor para cartas de intercambio
    public Card() {
        this.type = CardType.EXCHANGE;
        this.associatedCountry = null;
        this.associatedObjective = null;
    }



    public Country getAssociatedCountry() {
        if (type != CardType.COUNTRY) {
            throw new IllegalStateException("This card is not associated with a country");
        }
        return associatedCountry;
    }

    public Objective getAssociatedObjective() {
        if (type != CardType.OBJECTIVE) {
            throw new IllegalStateException("This card does not contain an objective");
        }
        return associatedObjective;
    }
    */

}
