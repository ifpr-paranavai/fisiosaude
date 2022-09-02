package br.edu.ifpr.medsaudelib.controller;

import br.edu.ifpr.medsaudelib.entity.Usuario;
import br.edu.ifpr.medsaudelib.repository.UsuarioRepository;
import br.edu.ifpr.medsaudelib.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/test")
public class TesteController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PreAuthorize("hasPermission('null', {'ROLE_USER', 'PERM_PROCURACAO'})")
    @GetMapping
    public ResponseEntity<String> auth(){
        System.out.println("Teste");
        return ResponseEntity.ok("Testado");
    }

    public void validUserRequest(String role) {

    }

    @GetMapping("/getUsuario/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable long id) {
        Optional<Usuario> usuarioReturn = usuarioRepository.findById(id);

        return ResponseEntity.ok(usuarioReturn);
    }
}
