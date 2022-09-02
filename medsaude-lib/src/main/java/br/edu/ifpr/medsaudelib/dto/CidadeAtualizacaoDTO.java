package br.edu.ifpr.medsaudelib.dto;

import br.edu.ifpr.medsaudelib.entity.Cidade;
import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.repository.CidadeRepository;
import br.edu.ifpr.medsaudelib.repository.EstadoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CidadeAtualizacaoDTO {

    @NotNull @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade atualizar(Long id, CidadeRepository cidadeRepository) {
        Cidade cidade = cidadeRepository.getReferenceById(id);

        cidade.setNome(this.nome);

        return cidade;
    }
}
