package br.edu.ifpr.medsaudelib.controller;

import br.edu.ifpr.medsaudelib.dto.*;
import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.entity.Usuario;
import br.edu.ifpr.medsaudelib.mapper.EstadoMapper;
import br.edu.ifpr.medsaudelib.repository.EstadoRepository;
import br.edu.ifpr.medsaudelib.repository.UsuarioRepository;
import br.edu.ifpr.medsaudelib.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> criar(@RequestBody EstadoDTO estadoDTO) {
        if (estadoDTO != null && estadoDTO.getNome() != null) {
            Optional<Estado> estado = estadoRepository.findByNome(estadoDTO.getNome());

            if (!estado.isPresent()) {
                Estado estadoEntity = EstadoMapper.convertToEntity(estadoDTO);

                estadoRepository.save(estadoEntity);


                return new ResponseEntity<>(EstadoMapper.convertToVo(estadoEntity), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Estado já cadastrado", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Sem conteúdo", HttpStatus.NO_CONTENT);
    }



    @GetMapping("/listar")
    public List<EstadoDTO> listar() {
        List<Estado> listaEstados = estadoRepository.findAll();

        return EstadoMapper.convertToListVo(listaEstados);
    }


    @GetMapping("/detalhar/{id}")
    public ResponseEntity<EstadoDTO> detalhar(@PathVariable Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);


        if (estado.isPresent()) {
            EstadoDTO estadoDTO = EstadoMapper.convertToVo(estado.get());

            return ResponseEntity.ok(estadoDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/editar/{id}")
    @Transactional
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EstadoAtualizacaoDTO estadoAtualizacaoDTO) {
        Optional<Estado> estado = estadoRepository.findById(id);

        if (estado.isPresent()) {
            Estado estadoAtualizado = estadoAtualizacaoDTO.atualizar(id, estadoRepository);
            return ResponseEntity.ok(EstadoMapper.convertToVo(estadoAtualizado));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Estado> topico = estadoRepository.findById(id);

        if (topico.isPresent()) {
            estadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


}
