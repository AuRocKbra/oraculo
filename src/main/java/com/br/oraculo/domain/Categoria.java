package com.br.oraculo.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_CATEGORIA")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_CATEGORIA")
    private Integer codigoCategoria;

    @Column(name = "NM_CATEGORIA")
    private String nomeCategoria;

    @Column(name = "DS_IDENTIFICACAO_CATEGORIA")
    private String codigoIdentificacaoCategoria;

    public Categoria(String nomeCategoria,String codigoIdentificacaoCategoria){
        this.nomeCategoria = nomeCategoria;
        this.codigoIdentificacaoCategoria = codigoIdentificacaoCategoria.toUpperCase();
    }
}
