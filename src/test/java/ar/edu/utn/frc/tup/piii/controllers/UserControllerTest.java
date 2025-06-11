package ar.edu.utn.frc.tup.piii.controllers;


import ar.edu.utn.frc.tup.piii.dtos.UserLoginDto;
import ar.edu.utn.frc.tup.piii.dtos.UserRegisterDto;
import ar.edu.utn.frc.tup.piii.dtos.UserResponseDto;
import ar.edu.utn.frc.tup.piii.models.User;
import ar.edu.utn.frc.tup.piii.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_success() {
        UserRegisterDto userToCreateDto = UserRegisterDto.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("123456")
                .build();

        User userRegistered = User.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("123456")
                .build();

        when(userService.createUser(any())).thenReturn(userRegistered);
        ResponseEntity<UserResponseDto> result = userController.createUser(userToCreateDto);

        assertEquals(result.getBody().getUserName(), userToCreateDto.getUserName());
        assertEquals(result.getBody().getEmail(), userToCreateDto.getEmail());
    }

    @Test
    void login_success() {
        UserLoginDto userToLoginDto = UserLoginDto.builder()
                .email("ignaciomarucco@gmail.com")
                .password("123456")
                .build();


        User userLogged = User.builder()
                .email("ignaciomarucco@gmail.com")
                .password("123456")
                .build();

        when(userService.loginUser(any())).thenReturn(userLogged);
        ResponseEntity<UserResponseDto> result = userController.login(userToLoginDto);

        assertEquals(result.getBody().getUserName(), userLogged.getUserName());
        assertEquals(result.getBody().getEmail(), userLogged.getEmail());
    }
}