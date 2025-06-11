package ar.edu.utn.frc.tup.piii.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerPostDto {
    private String name;
    private Boolean isCurrentPlayer;
    private List<Integer> objectives;
    private Integer user;
    private Integer color;
    private Integer numberOfExchanges;
    private Integer troopsToAdd;
}
