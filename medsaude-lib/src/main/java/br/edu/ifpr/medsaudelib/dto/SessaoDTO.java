package br.edu.ifpr.medsaudelib.dto;

import br.edu.ifpr.medsaudelib.entity.ItemSessao;
import br.edu.ifpr.medsaudelib.entity.TipoServico;
import lombok.Data;

import java.util.List;

@Data
public class SessaoDTO {

    private Long id;
    private FisioterapeutaDTO fisioterapeuta;
    private PacienteDTO paciente;
    private String diagnostico;
    private Integer quantidadeSessoes;
    private TipoServicoDTO tipoServico;
    private List<ItemSessao> listaSessoes;
    private Character status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FisioterapeutaDTO getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(FisioterapeutaDTO fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Integer getQuantidadeSessoes() {
        return quantidadeSessoes;
    }

    public void setQuantidadeSessoes(Integer quantidadeSessoes) {
        this.quantidadeSessoes = quantidadeSessoes;
    }

    public TipoServicoDTO getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoDTO tipoServico) {
        this.tipoServico = tipoServico;
    }

    public List<ItemSessao> getListaSessoes() {
        return listaSessoes;
    }

    public void setListaSessoes(List<ItemSessao> listaSessoes) {
        this.listaSessoes = listaSessoes;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
