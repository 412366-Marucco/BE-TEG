package ar.edu.utn.frc.tup.piii.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MatchCountryId {
    private Integer matchId;
    private Integer countryId;
}
