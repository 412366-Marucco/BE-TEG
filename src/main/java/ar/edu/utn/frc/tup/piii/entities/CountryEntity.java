package ar.edu.utn.frc.tup.piii.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "countries")
public class CountryEntity {
    @Id
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_continent", nullable = false)
    private ContinentEntity continent;


    @ManyToMany
    @JoinTable(
            name = "limits",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "adjacent_country_id")
    )
    private List<CountryEntity> adjacentCountries = new ArrayList<>();

}
