package com.br.oraculo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.br.oraculo.domain.Categoria;
import com.br.oraculo.domain.dto.TicketInsertDTO;
import com.br.oraculo.domain.dto.TicketListagemDTO;
import com.br.oraculo.domain.Ticket;
import com.br.oraculo.domain.dto.TicketDTO;
import com.br.oraculo.enums.Status;
import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

class TesteTicketService {

    @Mock
    private TicketRepository ticketRepository;


    @Mock
    private CategoriaService categoriaService;


    @Mock
    private Logger log;


    @InjectMocks
    private TicketService ticketService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de recuperar todos os tickets DTO")
    void testRecurperarTodosTicketsOk() {
        Ticket ticket = new Ticket();
        ticket.setStatus(Status.AGUARDANDO_ATENDIMENTO.getCodigoStatus());
        when(ticketRepository.findAll()).thenReturn(Collections.singletonList(ticket));
        List<TicketListagemDTO> resultado = ticketService.recurperarTodosTicketsDTO();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(ticketRepository, times(1)).findAll();
    }


    @Test
    @DisplayName("Teste de recuperar todos os tickets")
    void testRecurperarTodosTickets() {
        Ticket ticket = new Ticket();
        when(ticketRepository.findAll()).thenReturn(Collections.singletonList(ticket));
        List<Ticket> resultado = ticketService.recurperarTodosTickets();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(ticketRepository, times(1)).findAll();
    }


    @Test
    @DisplayName("Teste recupera ticket por id ok")
    void testRecuperarTicketPorIdOk() {
        Ticket ticket = new Ticket();
        when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
        Ticket resultado = ticketService.recuperarTicketPorId(1);
        assertNotNull(resultado);
        verify(ticketRepository, times(1)).findById(1);
    }


    @Test
    @DisplayName("Teste recupera ticket por id erro")
    void testRecuperarTicketPorIdRecursoNaoEncontrado() {
        when(ticketRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(RecursoNaoEncontradoException.class, () -> {
            ticketService.recuperarTicketPorId(1);
        });
        verify(ticketRepository, times(1)).findById(1);
    }


    @Test
    @DisplayName("Teste cria ticket OK")
    void testCriarTicketOk() {
        Categoria categoria = new Categoria();
        TicketDTO novoTicket = new TicketDTO("descrição", "título", 1);
        Ticket ticket = new Ticket("descrição", "título", categoria);
        ticket.setIdTicket(1);
        when(categoriaService.recuperarCategoriaPorId(novoTicket.categoria())).thenReturn(categoria);
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
        Integer id = ticketService.criarTicket(novoTicket);
        assertEquals(1, id);
        verify(categoriaService, times(1)).recuperarCategoriaPorId(novoTicket.categoria());
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }


    @Test
    @DisplayName("Teste criar ticket erro interno")
    void testCriarTicketErroInterno() {
        Categoria categoria = new Categoria();
        TicketDTO novoTicket = new TicketDTO("descrição", "título", 1);
        when(categoriaService.recuperarCategoriaPorId(novoTicket.categoria())).thenReturn(categoria);
        when(ticketRepository.save(any(Ticket.class))).thenThrow(RuntimeException.class);
        assertThrows(ErroInternoException.class, () -> {
            ticketService.criarTicket(novoTicket);
        });
        verify(categoriaService, times(1)).recuperarCategoriaPorId(novoTicket.categoria());
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }


    @Test
    @DisplayName("Teste atualizar ticket ok")
    void testAtualizarTicketSucesso() {
        Categoria categoria = new Categoria();
        TicketInsertDTO novosDados = new TicketInsertDTO("Novo título", "Nova descrição", 1, Status.AGUARDANDO_ATENDIMENTO.getCodigoStatus());
        Ticket ticketExistente = new Ticket();
        ticketExistente.setDescricao(novosDados.descricao());
        ticketExistente.setTitulo(novosDados.titulo());
        ticketExistente.setStatus(novosDados.status());
        when(ticketRepository.findById(1)).thenReturn(Optional.of(ticketExistente));
        when(categoriaService.recuperarCategoriaPorId(novosDados.categoria())).thenReturn(categoria);
        Ticket resultado = ticketService.atualizarTicket(novosDados, 1);
        assertEquals("Nova descrição", resultado.getDescricao());
        assertEquals("Novo título", resultado.getTitulo());
        assertEquals(Status.AGUARDANDO_ATENDIMENTO.getCodigoStatus(), resultado.getStatus());
        verify(ticketRepository, times(1)).findById(1);
        verify(categoriaService, times(1)).recuperarCategoriaPorId(novosDados.categoria());
        verify(ticketRepository, times(1)).save(ticketExistente);
    }
}
