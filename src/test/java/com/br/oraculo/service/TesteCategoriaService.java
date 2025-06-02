package com.br.oraculo.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.br.oraculo.domain.Categoria;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.CategoriaRepository;

import java.util.Optional;


class TesteCategoriaService {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de criação de categoria")
    void testCriarCategoria() {
        Categoria novaCategoria = new Categoria();
        novaCategoria.setCodigoCategoria(1);
        when(categoriaRepository.save(novaCategoria)).thenReturn(novaCategoria);
        Integer codigoCategoria = categoriaService.criarCategoria(novaCategoria);
        assertEquals(1, codigoCategoria);
        verify(categoriaRepository, times(1)).save(novaCategoria);
    }


    @Test
    @DisplayName("Teste de recuperar dados categoria por ID")
    void testRecuperarCategoriaPorIdOk() {
        Categoria categoria = new Categoria();
        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));
        Categoria resultado = categoriaService.recuperarCategoriaPorId(1);
        assertNotNull(resultado);
        verify(categoriaRepository, times(1)).findById(1);
    }


    @Test
    @DisplayName("Teste para recuperar dados categoria erro")
    void testRecuperarCategoriaPorIdRecursoNaoEncontrado() {
        when(categoriaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(RecursoNaoEncontradoException.class, () -> {
            categoriaService.recuperarCategoriaPorId(1);
        });
        verify(categoriaRepository, times(1)).findById(1);
    }

}