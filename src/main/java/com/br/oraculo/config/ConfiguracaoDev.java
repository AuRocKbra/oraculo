package com.br.oraculo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.oraculo.service.CriaBancoDevService;

@Configuration
@Profile("dev")
public class ConfiguracaoDev {

    private CriaBancoDevService criaBancoDevService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String criarBanco;

    public ConfiguracaoDev (CriaBancoDevService criaBancoDevService){
        this.criaBancoDevService = criaBancoDevService;
    }

    @Bean
    public boolean criarTicketsExemplos(){
        if("create".equalsIgnoreCase(criarBanco)){
            criaBancoDevService.criarTicketsExemplos();
            return true;
        }
        return false;
    }
}
