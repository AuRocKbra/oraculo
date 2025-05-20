package com.br.oraculo.exception;


public class RecursoNaoEncontradoException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException( String mensagem){
        super(mensagem);
    }

    public RecursoNaoEncontradoException(String mensagem, Throwable erro){
        super(mensagem,erro);
    }
}
