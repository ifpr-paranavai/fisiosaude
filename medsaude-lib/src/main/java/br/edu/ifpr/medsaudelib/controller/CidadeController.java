package br.edu.ifpr.medsaudelib.controller;

import br.edu.ifpr.medsaudelib.dto.CidadeAtualizacaoDTO;
import br.edu.ifpr.medsaudelib.dto.CidadeDTO;
import br.edu.ifpr.medsaudelib.entity.Cidade;
import br.edu.ifpr.medsaudelib.mapper.CidadeMapper;
import br.edu.ifpr.medsaudelib.repository.CidadeRepository;
import br.edu.ifpr.medsaudelib.repository.EstadoRepository;
import br.edu.ifpr.medsaudelib.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> criar(@RequestBody CidadeDTO cidadeDTO) {
        if (cidadeDTO != null && cidadeDTO.getNome() != null) {
            Optional<Cidade> cidade = cidadeRepository.findByNome(cidadeDTO.getNome());


            if (!cidade.isPresent()) {
                Cidade cidadeEntity = CidadeMapper.convertToEntity(cidadeDTO);

                cidadeRepository.save(cidadeEntity);


                return new ResponseEntity<>(CidadeMapper.convertToVo(cidadeEntity), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Cidade já cadastrada", HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Sem conteúdo", HttpStatus.NO_CONTENT);
    }



    @GetMapping("/listar")
    public List<CidadeDTO> listar() {
        List<Cidade> listaCidades = cidadeRepository.findAll();

        return CidadeMapper.convertToListVo(listaCidades);
    }


    @GetMapping("/detalhar/{id}")
    public ResponseEntity<CidadeDTO> detalhar(@PathVariable Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);


        if (cidade.isPresent()) {
            CidadeDTO cidadeDTO = CidadeMapper.convertToVo(cidade.get());

            return ResponseEntity.ok(cidadeDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/editar/{id}")
    @Transactional
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CidadeAtualizacaoDTO cidadeAtualizacaoDTO) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        if (cidade.isPresent()) {
            Cidade cidadeAtualizada = cidadeAtualizacaoDTO.atualizar(id, cidadeRepository);
            return ResponseEntity.ok(CidadeMapper.convertToVo(cidadeAtualizada));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        if (cidade.isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


}
