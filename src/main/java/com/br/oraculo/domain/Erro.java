package com.br.oraculo.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Erro implements Serializable{

    private static final long serialVersionUID = 1L;

    public Erro(){}

    private String titulo;
    private String mensagemErro;
    private Integer statusCode;
    private Throwable erros;

    public Erro(String titulo, String mensagemErro,Integer statusCode){
        this.titulo = titulo;
        this.mensagemErro = mensagemErro;
        this.statusCode = statusCode;
    }

    public Erro(String titulo, String mensagemErro,Integer statusCode,Throwable erros){
        this.titulo = titulo;
        this.mensagemErro = mensagemErro;
        this.statusCode = statusCode;
        this.erros= erros;
    }
}
