package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //Esta clase esta mapeada a una tabla
@Table(name = "app_users") //Cambiar el nombre de tabla
@Data //Getters Setters, required, value, hashcode
@NoArgsConstructor //El constructor vacio
@AllArgsConstructor //El constructor con todos
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime lastLogin;
}
