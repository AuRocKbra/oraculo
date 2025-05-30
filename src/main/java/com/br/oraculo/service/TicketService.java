package com.br.oraculo.service;

import java.util.List;

import com.br.oraculo.domain.Categoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.br.oraculo.domain.Ticket;
import com.br.oraculo.domain.dto.TicketDTO;
import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.TicketRepository;
import com.br.oraculo.utils.TemplateMensagens;

@Service
@Slf4j
public class TicketService {

    private TicketRepository ticketRepository;
    private CategoriaService categoriaService;

    public TicketService(TicketRepository ticketRepository, CategoriaService categoriaService){
        this.ticketRepository = ticketRepository;
        this.categoriaService = categoriaService;
    }

    public List<Ticket> recurperarTodosTickets(){
        return ticketRepository.findAll();
    }

    public Ticket recuperarTicketPorId(Long id){
        return ticketRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException(TemplateMensagens.RECURSO_NAO_ENCONTRATO));
    }

    public Integer criarTicket(TicketDTO novoTicket){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"serviço de crição de ticket");
        Categoria categoria = categoriaService.recuperarCategoriaPorId(novoTicket.categoria());
        try{
            Ticket ticketCriado = ticketRepository.save(new Ticket(novoTicket.descricao(),novoTicket.titulo(),categoria));
            return ticketCriado.getIdTicket();
        }catch(Exception e){
            log.error(TemplateMensagens.ERRO_ROTINA,"o registro do ticket",e.getMessage());
            throw new ErroInternoException(TemplateMensagens.ERRO_INTERNO,new Throwable("ERRO-CAD-TIC"));
        }    
    }

    public Ticket atualizarTicket(TicketDTO dadosNovosTicket,Long idTicket){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"serviço de atualização de ticket");
        Ticket dadosTicketBanco = recuperarTicketPorId(idTicket);
        Categoria categoria = categoriaService.recuperarCategoriaPorId(dadosNovosTicket.categoria());
        try {
            dadosTicketBanco.setCategoria(categoria);
            dadosTicketBanco.setDescricao(dadosNovosTicket.descricao());
            dadosTicketBanco.setTitulo(dadosNovosTicket.titulo());
            ticketRepository.save(dadosTicketBanco);
            return dadosTicketBanco;
        }catch (Exception e){
            log.error(TemplateMensagens.ERRO_ROTINA,"a atualização do ticket",e.getMessage());
            throw new ErroInternoException(TemplateMensagens.ERRO_INTERNO,new Throwable("ERRO-ATT_TIC"));
        }
    }
}
