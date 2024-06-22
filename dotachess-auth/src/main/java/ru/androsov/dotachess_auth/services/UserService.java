package ru.androsov.dotachess_auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.androsov.dotachess_auth.model.entities.UserEntity;
import ru.androsov.dotachess_auth.repositories.UserRepository;
import ru.androsov.feignclientstarter.dotachess.auth.model.RegistrationRequest;
import ru.androsov.rest.throwable.exception.BadRequestException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder  passwordEncoder;

    public UserEntity createUser(RegistrationRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
            throw new BadRequestException("USERNAME_ALREADY_IN_USE", "Username is already in use");

        UserEntity user = new UserEntity();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }
}
