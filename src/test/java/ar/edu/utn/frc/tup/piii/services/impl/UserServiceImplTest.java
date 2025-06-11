package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.entities.UserEntity;
import ar.edu.utn.frc.tup.piii.models.User;
import ar.edu.utn.frc.tup.piii.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_Success() {

        User userToCreate = User.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("1234567")
                .build();

        UserEntity userEntityCreated = UserEntity.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("1234567")
                .createdAt(LocalDateTime.now())
                .lastLogin(null)
                .build();

        //Simulo que no existe previamente, para que pueda proceder con el createUser
        when(userRepository.getByEmail(userToCreate.getEmail())).thenReturn(Optional.empty());

        when(userRepository.save(any())).thenReturn(userEntityCreated);

        User result = userServiceImpl.createUser(userToCreate);

        assertEquals(userToCreate.getUserName(), result.getUserName());
        assertEquals(userToCreate.getEmail(), result.getEmail());
        assertEquals(userToCreate.getPassword(), result.getPassword());

    }

    @Test
    void createUser_EmailAlreadyExists() {
        User userToCreate = User.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("1234567")
                .build();

        UserEntity userEntityOptional = UserEntity.builder()
                .userName("NachoMarucco")
                .email("ignaciomarucco@gmail.com")
                .password("asdfgh")
                .build();

        //Simulo que ya existe previamente
        when(userRepository.getByEmail(userToCreate.getEmail()))
                .thenReturn(Optional.of(userEntityOptional));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userServiceImpl.createUser(userToCreate);
        });

        assertEquals("El email ya existe.", exception.getMessage());
    }


    @Test
    void loginUser_Success() {

        User userToLog = User.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("1234567")
                .build();

        UserEntity userEntityLogged = UserEntity.builder()
                .userName("Nacho")
                .email("ignaciomarucco@gmail.com")
                .password("1234567")
                .createdAt(LocalDateTime.now())
                .lastLogin(null)
                .build();

        //Simulo que no existe previamente, para que pueda proceder con el createUser
        when(userRepository.getByEmail(userToLog.getEmail())).thenReturn(Optional.empty());

        when(userRepository.save(any())).thenReturn(userEntityLogged);

        User result = userServiceImpl.createUser(userToLog);

        assertEquals(userToLog.getUserName(), result.getUserName());
        assertEquals(userToLog.getEmail(), result.getEmail());
        assertEquals(userToLog.getPassword(), result.getPassword());

    }
}