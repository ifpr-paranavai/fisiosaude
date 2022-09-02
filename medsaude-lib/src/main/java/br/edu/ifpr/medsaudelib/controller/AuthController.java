package br.edu.ifpr.medsaudelib.controller;

import br.edu.ifpr.medsaudelib.dto.EstadoDTO;
import br.edu.ifpr.medsaudelib.dto.LoginDTO;
import br.edu.ifpr.medsaudelib.dto.TokenDTO;
import br.edu.ifpr.medsaudelib.dto.UsuarioDTO;
import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.entity.Fisioterapeuta;
import br.edu.ifpr.medsaudelib.entity.Usuario;
import br.edu.ifpr.medsaudelib.mapper.EstadoMapper;
import br.edu.ifpr.medsaudelib.repository.FisioterapeutaRepository;
import br.edu.ifpr.medsaudelib.repository.UsuarioRepository;
import br.edu.ifpr.medsaudelib.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FisioterapeutaRepository fisioterapeutaRepository;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(TokenDTO.builder().type("Bearer").token(token).build());

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCrypt = bCryptPasswordEncoder.encode(usuarioDTO.getSenha());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(senhaCrypt);

        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }


//    @GetMapping("/listar")
//    public List<?> listar() {
//        List<Fisioterapeuta> listaEstados = fisioterapeutaRepository.findAll();
//
//        return listaEstados;
//    }


}
