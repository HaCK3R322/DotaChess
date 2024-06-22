package ru.androsov.dotachess_auth.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
}
