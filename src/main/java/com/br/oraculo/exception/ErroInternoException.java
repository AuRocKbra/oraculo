package com.br.oraculo.exception;

public class ErroInternoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ErroInternoException (String mensagem){
        super(mensagem);
    }

    public ErroInternoException(String mensagem, Throwable erro){
        super(mensagem,erro);
    }
}
