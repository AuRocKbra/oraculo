package com.br.oraculo.resource;

import com.br.oraculo.utils.TemplateMensagens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
@Slf4j
public class HealthResource {

    @GetMapping("/health")
    public String getMethodName() {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para verificar se api está em execução");
        return new String("Aplicação em execução "+new Date());
    }
    
}
