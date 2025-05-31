package com.br.oraculo.handler;

import com.br.oraculo.utils.FiltroMensagensException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.oraculo.domain.Erro;
import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.exception.RequisicaoErradaException;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

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
        Erro detalheErro = new Erro("Erro no processamento",exception.getLocalizedMessage(),HttpServletResponse.SC_NOT_FOUND);
        return ResponseEntity.status(detalheErro.getStatusCode()).header(HEARDER,VALOR_CONTENTI_TYPE).body(detalheErro);
    }

    @ExceptionHandler(RequisicaoErradaException.class)
    public ResponseEntity<Erro> handlerRequisicaoErrada(RequisicaoErradaException exception){
        Erro detalheErro = new Erro("Requisição errada",exception.getLocalizedMessage(),HttpServletResponse.SC_BAD_REQUEST);
        return ResponseEntity.status(detalheErro.getStatusCode()).header(HEARDER,VALOR_CONTENTI_TYPE).body(detalheErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> handlerRequisicaoErrada(MethodArgumentNotValidException exception){
        List<String> erros = FiltroMensagensException.filtrarMensagemArquimentoInvalido(exception);
        Erro detalheErro = new Erro("Requisição errada","Opa, algo não está certo",HttpServletResponse.SC_BAD_REQUEST,erros);
        return ResponseEntity.status(detalheErro.getStatusCode()).header(HEARDER,VALOR_CONTENTI_TYPE).body(detalheErro);
    }

}
