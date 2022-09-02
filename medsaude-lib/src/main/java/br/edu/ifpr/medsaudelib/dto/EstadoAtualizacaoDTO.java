package br.edu.ifpr.medsaudelib.dto;

import br.edu.ifpr.medsaudelib.entity.Estado;
import br.edu.ifpr.medsaudelib.repository.EstadoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstadoAtualizacaoDTO {

    @NotNull @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Length(max = 2)
    private String sigla;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getReferenceById(id);

        estado.setNome(this.nome);
        estado.setSigla(this.sigla);

        return estado;
    }
}
