package com.br.oraculo.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TICKET")
    private Long idTicket;

    @Column(name ="DS_DESCRICAO")
    private String descricao;

    @Column(name = "DS_SENTIMENTO")
    private String sentimento;

    @Column(name = "DS_TITULO")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "CD_CATEGORIA")
    private Categoria categoria;

    public Ticket (String descricao, String sentimento, String titulo, Categoria categoria){
        this.descricao = descricao;
        this.sentimento = sentimento;
        this.titulo = titulo;
        this.categoria = categoria;
    }
}
