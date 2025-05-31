package com.br.oraculo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class FiltroMensagensException {

    private FiltroMensagensException(){}

    public static List<String> filtrarMensagemArquimentoInvalido(MethodArgumentNotValidException exception){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"rotina de filtro de mensagem de erro de argumentos");
        Map<String,String> erros = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            erros.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        List<String> listaMensagemErros = new ArrayList<>();
        erros.forEach((campo,valor) -> listaMensagemErros.add(valor));
        return listaMensagemErros;
    }

    public static List<String> filtraThrowbleDeException(Throwable erro){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"rotina de filtro de throwble");
        return Stream.of(erro.getMessage()).toList();
    }
}
