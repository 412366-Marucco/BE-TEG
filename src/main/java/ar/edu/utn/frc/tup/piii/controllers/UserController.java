package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.dtos.UserDto;
import ar.edu.utn.frc.tup.piii.dtos.UserLoginDto;
import ar.edu.utn.frc.tup.piii.dtos.UserRegisterDto;
import ar.edu.utn.frc.tup.piii.dtos.UserResponseDto;
import ar.edu.utn.frc.tup.piii.models.User;
import ar.edu.utn.frc.tup.piii.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    /**
     * Crea un nuevo usuario.
     *
     * @param userRegisterDto Objeto que contiene los datos del usuario a crear.
     * @return El usuario creado como un objeto UserDto, con los datos que quiera exponer.
     * @throws IllegalArgumentException si el email ya existe en el sistema.
     */
    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        // 1. Mapear DTO a modelo de dominio
        User user = User.builder()
                .userName(userRegisterDto.getUserName())
                .email(userRegisterDto.getEmail())
                .password(userRegisterDto.getPassword())
                .build();

        // 2. Llamar al servicio
        User userCreated = userService.createUser(user);

        // 3. Mapear model a DTO para devolverlo al cliente, con los campos que queremos devolver
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .userName(userCreated.getUserName())
                .email(userCreated.getEmail())
                .build();

        return ResponseEntity.ok(userResponseDto);
    }

    /**
     * Autentica a un usuario en el sistema.
     *
     * @param userLoginDto Objeto que contiene las credenciales del usuario (email y contraseña).
     * @return Un objeto UserResponseDto con los datos del usuario autenticado (sin información sensible).
     * @throws IllegalArgumentException si las credenciales son incorrectas.
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        // 1. Mapear DTO a modelo de dominio
        User user = User.builder()
                .email(userLoginDto.getEmail())
                .password(userLoginDto.getPassword())
                .build();
        // 2. Llamar al servicio
        User userLogin = userService.loginUser(user);
        // 3. Mapear model a DTO para devolverlo al cliente, con los campos que queremos devolver
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .userName(userLogin.getUserName())
                .email(userLogin.getEmail())
                .build();

        return ResponseEntity.ok(userResponseDto);
    }
}
