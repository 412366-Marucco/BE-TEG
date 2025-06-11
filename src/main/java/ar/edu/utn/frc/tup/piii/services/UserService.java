package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User createUser(User user);

    User loginUser(User user);
}
