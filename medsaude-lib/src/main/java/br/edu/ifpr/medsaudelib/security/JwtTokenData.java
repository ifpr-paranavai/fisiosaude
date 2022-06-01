package br.edu.ifpr.medsaudelib.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtTokenData {
    private UsuarioContext usuario;
}
