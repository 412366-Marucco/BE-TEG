package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="match_countries")
public class MatchCountryEntity {
    @EmbeddedId
    private MatchCountryId id;

    @ManyToOne
    @MapsId("matchId")
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity match;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity owner;

    @Column(name = "troops")
    private int troops;
}
