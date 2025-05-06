package br.com.fiap.cash_up_api.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.cash_up_api.model.Credentials;
import br.com.fiap.cash_up_api.model.Token;
import br.com.fiap.cash_up_api.model.User;
import br.com.fiap.cash_up_api.model.UserRole;

@Service
public class TokenService {

    private final Long DURATION = 10L; // 10 minutes
    private final Algorithm ALG = Algorithm.HMAC256("secret");

    public Token createToken(User user){
        var token = JWT.create()
            .withSubject(user.getId().toString())
            .withClaim("email", user.getEmail())
            .withClaim("role", user.getRole().toString())
            .withExpiresAt(LocalDateTime.now().plusMinutes(DURATION).toInstant(ZoneOffset.ofHours(-3)))
            .sign(ALG);
        return new Token(token, 21315656L, "Bearer", user.getRole().toString());

    }

    public User getUserFromToken(String token) {
        var verifiedToken = JWT.require(ALG)
                                .build()
                                .verify(token);

        return User
                    .builder()
                    .id(Long.parseLong( verifiedToken.getSubject() ))
                    .email(verifiedToken.getClaim("email").toString())
                    .role(UserRole.valueOf(verifiedToken.getClaim("role").asString()))
                    .build();
                                
    }
    
}
