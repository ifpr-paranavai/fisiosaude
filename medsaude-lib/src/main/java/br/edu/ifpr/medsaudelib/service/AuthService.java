package br.edu.ifpr.medsaudelib.service;

import br.edu.ifpr.medsaudelib.dto.LoginDTO;
import br.edu.ifpr.medsaudelib.entity.Usuario;
import br.edu.ifpr.medsaudelib.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private TokenService tokenService;

    public String login(LoginDTO loginDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.encode(loginDTO.getPass());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUser(), loginDTO.getPass());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenService.generateJwtToken(usuario);

        return token;
//        return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());
    }
}
