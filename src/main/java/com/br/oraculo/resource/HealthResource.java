package com.br.oraculo.resource;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class HealthResource {

    @GetMapping("/health")
    public String getMethodName() {
        return new String("Aplicação em execução "+new Date());
    }
    
}
