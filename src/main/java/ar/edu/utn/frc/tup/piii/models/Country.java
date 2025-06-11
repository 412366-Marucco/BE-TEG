package ar.edu.utn.frc.tup.piii.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Country {

    private int id;
    private String name;
    private Continent continent;
    private List<Country> neighbours;

    public String toString(){

        return name;
    }
}
