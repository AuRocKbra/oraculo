package com.br.oraculo.service;

import com.br.oraculo.exception.ErroInternoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TesteIntegracaoBanco {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private HealthService healthService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de integração e serviço de health da aplicação")
    void testeIntegracaoBancoHealthOK(){
        assertNotNull(healthService.consultaBancoUp());
        verify(categoriaService,times(1)).recuperarCategoriaPorId(1);
    }

    @Test
    @DisplayName("Teste de integração e serviço de health da aplicação com erro")
    void testeIntegracaoBancoHealthErroInterno(){
        when(categoriaService.recuperarCategoriaPorId(1)).thenThrow(new MockitoException("Erro"));
        assertThrows(ErroInternoException.class,()->{healthService.consultaBancoUp();});
        verify(categoriaService,times(1)).recuperarCategoriaPorId(1);
    }
}
