package br.com.fiap.cash_up_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.cash_up_api.model.Credentials;
import br.com.fiap.cash_up_api.model.Token;
import br.com.fiap.cash_up_api.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username, null));
        System.out.println("User found:" + user);
        return user;
    }

    public Token login(Credentials credentials){
        var user = repository.findByEmail(credentials.email())
            .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado", null));

        if(!passwordEncoder.matches(credentials.password(), user.getPassword()) ){
            throw new BadCredentialsException("Senha incorreta");
        }

        return tokenService.createToken(user);
    }



}
