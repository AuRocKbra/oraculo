package com.br.oraculo.exception;

import java.util.List;

public class ErroInternoException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public ErroInternoException (String mensagem){
        super(mensagem);
    }

    public ErroInternoException(String mensagem, Throwable erro){
        super(mensagem,erro);
    }
}
