package com.br.oraculo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.oraculo.domain.Ticket;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.TicketRepository;
import com.br.oraculo.utils.TemplateMensagens;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> recurperarTodosTickets(){
        return ticketRepository.findAll();
    }

    public Ticket recuperaTicketPorId(Long id){
        return ticketRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException(TemplateMensagens.RECURSO_NAO_ENCONTRATO));
    }
}
