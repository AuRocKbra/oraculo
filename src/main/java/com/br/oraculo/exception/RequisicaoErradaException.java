package com.br.oraculo.exception;

public class RequisicaoErradaException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RequisicaoErradaException(String mensagem){
        super(mensagem);
    }

    public RequisicaoErradaException(String mensagem, Throwable erro){
        super(mensagem,erro);
    }
}
