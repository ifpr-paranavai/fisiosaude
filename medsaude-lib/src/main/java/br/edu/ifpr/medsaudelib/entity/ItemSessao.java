package br.edu.ifpr.medsaudelib.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_sessao", schema = "medsaude")
public class ItemSessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_hora_sessao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraSessao;

    @Column(name = "concluida")
    private Boolean concluida;

    @Column(name = "falta")
    private Boolean falta;

    @OneToOne
    @Column(name = "item_sessao_origem")
    private ItemSessao itemSessaoOrigem;

    @Column(name = "status")
    private Character status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sessao", referencedColumnName = "id")
    private Sessao sessao;



}
