package ru.androsov.feignclientstarter.dotachess.auth.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtTokenDto {
    private String token;
}
