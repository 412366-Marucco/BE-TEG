package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchCountryId implements Serializable {

    @Column(name = "match_id")
    private Integer matchId;

    @Column(name = "country_id")
    private Integer countryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchCountryId that)) return false;
        return Objects.equals(matchId, that.matchId) &&
                Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, countryId);
    }
}
