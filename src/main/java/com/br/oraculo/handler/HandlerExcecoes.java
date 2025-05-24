package com.br.oraculo.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.oraculo.domain.Erro;
import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.exception.RecursoNaoEncontradoException;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class HandlerExcecoes {

    private static final String VALOR_CONTENTI_TYPE = "application/json;charset=UTF-8";
    private static final String HEARDER = "Content-Type";

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Erro> handlerRecursoNaoEncontrado(RecursoNaoEncontradoException exception){
        Erro detalheErro = new Erro("Requisição inválida",exception.getLocalizedMessage(),HttpServletResponse.SC_NOT_FOUND);
        return ResponseEntity.status(detalheErro.getStatusCode()).header(HEARDER,VALOR_CONTENTI_TYPE).body(detalheErro);
    }

    @ExceptionHandler(ErroInternoException.class)
    public ResponseEntity<Erro> handlerRecursoNaoEncontrado(ErroInternoException exception){
        Erro detalheErro = new Erro("Erro no processamento",exception.getLocalizedMessage(),HttpServletResponse.SC_NOT_FOUND,exception.getCause());
        return ResponseEntity.status(detalheErro.getStatusCode()).header(HEARDER,VALOR_CONTENTI_TYPE).body(detalheErro);
    }
}
