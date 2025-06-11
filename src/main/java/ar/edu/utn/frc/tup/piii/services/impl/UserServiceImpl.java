package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.entities.UserEntity;
import ar.edu.utn.frc.tup.piii.models.User;
import ar.edu.utn.frc.tup.piii.repositories.UserRepository;
import ar.edu.utn.frc.tup.piii.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param user Objeto de dominio que contiene los datos del usuario a crear.
     * @return El usuario creado como objeto User, incluyendo los datos relevantes.
     * @throws IllegalArgumentException si el email ya existe en el sistema.
     */
    @Override
    public User createUser(User user) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(user.getEmail());

        //Logica de negocio: No permitir email duplicados
        if (userEntityOptional.isPresent()) {
            throw new IllegalArgumentException("El email ya existe.");
        } else {
            // 1. Mapear Modelo de Dominio a Entity
            UserEntity userEntity = UserEntity.builder()
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .createdAt(LocalDateTime.now())
                    .build();

            // 2. Llamar al repositorio
            UserEntity userEntityCreated = userRepository.save(userEntity);

            // 3. Mapear entity a model para devolverlo al controller
            User userCreated = User.builder()
                    .userName(userEntityCreated.getUserName())
                    .email(userEntityCreated.getEmail())
                    .password(userEntityCreated.getPassword())
                    .createdAt(userEntityCreated.getCreatedAt())
                    .lastLogin(userEntityCreated.getLastLogin())
                    .build();

            return userCreated;
        }
    }

    /**
     * Autentica a un usuario con las credenciales provistas.
     *
     * @param user Objeto de dominio que contiene el email y contraseña del usuario.
     * @return El usuario autenticado como objeto User, sin exponer la contraseña.
     * @throws IllegalArgumentException si el email no existe o la contraseña es incorrecta.
     */
    @Override
    public User loginUser(User user) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(user.getEmail());

        if (!userEntityOptional.isPresent()) {
            throw new IllegalArgumentException("Email o contraseña incorrectos");
        }

        if (!user.getPassword().equals(userEntityOptional.get().getPassword())) {
            throw new IllegalArgumentException("Email o contraseña incorrectos");
        }

        // 1. Mapear Modelo de Dominio a Entity
        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        // 2. Llamar al repositorio (en realidad no, ya lo tendria)
        UserEntity userEntityLogged = userEntityOptional.get();

        // 3. Mapear entity a model para devolverlo al controller, sin password
        User userLogged = User.builder()
                .id(userEntityLogged.getId())
                .userName(userEntityLogged.getUserName())
                .email(userEntityLogged.getEmail())
                .createdAt(userEntityLogged.getCreatedAt())
                .lastLogin(userEntityLogged.getLastLogin())
                .build();

        return userLogged;
    }
}
