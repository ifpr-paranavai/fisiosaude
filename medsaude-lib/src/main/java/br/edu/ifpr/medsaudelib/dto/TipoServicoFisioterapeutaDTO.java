package br.edu.ifpr.medsaudelib.dto;

import lombok.Data;

@Data
public class TipoServicoFisioterapeutaDTO {

    private Long id;
    private TipoServicoDTO tipoServico;
    private FisioterapeutaDTO fisioterapeuta;
    private Character status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoServicoDTO getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoDTO tipoServico) {
        this.tipoServico = tipoServico;
    }

    public FisioterapeutaDTO getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(FisioterapeutaDTO fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
