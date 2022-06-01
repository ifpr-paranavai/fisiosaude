package br.edu.ifpr.medsaudelib.controller;

import br.edu.ifpr.medsaudelib.dto.LoginDTO;
import br.edu.ifpr.medsaudelib.dto.TokenDTO;
import br.edu.ifpr.medsaudelib.dto.UsuarioDTO;
import br.edu.ifpr.medsaudelib.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody @Validated UsuarioDTO usuarioDTO){
        ReturnData<Object> result = service.createUser(user.transformToEntity());

        return new ResponseEntity<>(result, result.getSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
