package com.br.oraculo.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.br.oraculo.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_TICKET")
public class Ticket implements Serializable{
    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TICKET")
    private Integer idTicket;

    @Column(name ="DS_DESCRICAO")
    private String descricao;

    @Column(name = "DS_TITULO")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "CD_CATEGORIA")
    private Categoria categoria;

    @Column(name = "CD_STATUS")
    private Integer status;

    public Ticket (String descricao, String titulo, Categoria categoria){
        this.descricao = descricao;
        this.titulo = titulo;
        this.categoria = categoria;
        this.status = Status.AGUARDANDO_ATENDIMENTO.getCodigoStatus();
    }
}
