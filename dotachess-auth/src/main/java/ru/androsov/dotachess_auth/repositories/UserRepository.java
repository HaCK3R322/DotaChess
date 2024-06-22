package ru.androsov.dotachess_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.androsov.dotachess_auth.model.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);
}
