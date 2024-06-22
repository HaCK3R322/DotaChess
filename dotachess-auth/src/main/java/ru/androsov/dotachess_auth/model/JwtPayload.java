package ru.androsov.dotachess_auth.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtPayload {
    private Long userId;
    private String username;
}
