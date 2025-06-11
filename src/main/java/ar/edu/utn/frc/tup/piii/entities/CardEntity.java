package ar.edu.utn.frc.tup.piii.entities;

import ar.edu.utn.frc.tup.piii.models.MatchCountry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private MatchCountryEntity associatedCountry;
    @ManyToOne
    private CardTypeEntity type;
}
