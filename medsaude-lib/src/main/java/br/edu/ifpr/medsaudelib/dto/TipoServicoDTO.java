package br.edu.ifpr.medsaudelib.dto;

import lombok.Data;

@Data
public class TipoServicoDTO {

    private Long id;
    private String descricao;
    private Double valorPorSessao;
    private Integer maximoAlunosPorSessao;
    private Character status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorPorSessao() {
        return valorPorSessao;
    }

    public void setValorPorSessao(Double valorPorSessao) {
        this.valorPorSessao = valorPorSessao;
    }

    public Integer getMaximoAlunosPorSessao() {
        return maximoAlunosPorSessao;
    }

    public void setMaximoAlunosPorSessao(Integer maximoAlunosPorSessao) {
        this.maximoAlunosPorSessao = maximoAlunosPorSessao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
