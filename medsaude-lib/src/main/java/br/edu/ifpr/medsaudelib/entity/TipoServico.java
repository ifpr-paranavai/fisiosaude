package br.edu.ifpr.medsaudelib.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_servico", schema = "medsaude")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_por_sessao")
    private Double valorPorSessao;

    @Column(name = "maximo_alunos_por_sessao")
    private Integer maximoAlunosPorSessao;

    @Column(name = "status")
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
