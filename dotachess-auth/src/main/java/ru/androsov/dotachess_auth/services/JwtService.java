package ru.androsov.dotachess_auth.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.androsov.dotachess_auth.model.entities.UserEntity;
import ru.androsov.dotachess_auth.repositories.UserRepository;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;

import javax.crypto.SecretKey;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        log.info(secret);

        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    private final UserRepository userRepository;

    public String generateToken(Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("USER_ID", userId);

        return Jwts.builder()
                .signWith(secretKey)
                .claims(claims)
                .compact();
    }

    public UserInfoDto parse(String token) throws EntityNotFoundException, JwtException, IllegalArgumentException {
        Jwt<JwsHeader, Claims> jws = Jwts.parser().decryptWith(secretKey).build().parseSignedClaims(token);
        Map<String, Object> payload = jws.getPayload();

        Long userId = (Long) payload.get("USER_ID");
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isEmpty()) {
            throw new EntityNotFoundException("User not found");
        }

        return UserInfoDto.builder()
                .id(userId)
                .username(userEntity.get().getUsername())
                .build();
    }
}