package br.edu.ifpr.medsaudelib.dto;

import lombok.Data;

@Data
public class FisioterapeutaDTO {

    private Long id;
    private Integer regProfissional;
    private UsuarioDTO usuario;
    private Character status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegProfissional() {
        return regProfissional;
    }

    public void setRegProfissional(Integer regProfissional) {
        this.regProfissional = regProfissional;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
