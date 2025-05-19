package com.br.oraculo.Resource;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/teste")
public class Testes {

    @GetMapping("/up")
    public String getMethodName() {
        return new String("Aplicação em execução "+new Date());
    }
    
}
