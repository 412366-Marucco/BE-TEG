package ar.edu.utn.frc.tup.piii.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Continent {
    private int id;
    private String name;
    private List<MatchCountry> countries;
    private int bonus;

    public String getName() {
        return name;
    }

    public List<MatchCountry> getCountries() {
        return countries;
    }

    public Continent(String name, List<MatchCountry> countries) {
        this.name = name;
        this.countries = countries;
    }

    //verifica si un jugador controla el continente completo y retorna el bonus
    public int getControlBonus(Player player) {
        for (MatchCountry country : countries) {
            if (!country.getOwner().equals(player)) {
                return 0;
            }
        }
        return bonus;
    }

    //Lista de países que componen el country
    public List<MatchCountry> getCountryList() {
        return countries;
    }

}
