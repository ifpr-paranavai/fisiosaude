package br.edu.ifpr.medsaudelib.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ItemSessaoDTO {

    private Long id;
    private Date dataHoraSessao;
    private Boolean concluida;
    private Boolean falta;
    private ItemSessaoDTO itemSessaoOrigem;
    private SessaoDTO sessao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHoraSessao() {
        return dataHoraSessao;
    }

    public void setDataHoraSessao(Date dataHoraSessao) {
        this.dataHoraSessao = dataHoraSessao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public Boolean getFalta() {
        return falta;
    }

    public void setFalta(Boolean falta) {
        this.falta = falta;
    }

    public ItemSessaoDTO getItemSessaoOrigem() {
        return itemSessaoOrigem;
    }

    public void setItemSessaoOrigem(ItemSessaoDTO itemSessaoOrigem) {
        this.itemSessaoOrigem = itemSessaoOrigem;
    }

    public SessaoDTO getSessao() {
        return sessao;
    }

    public void setSessao(SessaoDTO sessao) {
        this.sessao = sessao;
    }
}
