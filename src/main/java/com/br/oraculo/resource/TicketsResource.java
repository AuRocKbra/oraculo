package com.br.oraculo.resource;

import com.br.oraculo.domain.dto.TicketInsertDTO;
import com.br.oraculo.domain.dto.TicketListagemDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.oraculo.domain.Ticket;
import com.br.oraculo.domain.dto.TicketDTO;
import com.br.oraculo.service.TicketService;
import com.br.oraculo.utils.TemplateMensagens;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
@Slf4j
public class TicketsResource {

    private TicketService ticketService;

    public TicketsResource(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/tickets",produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<TicketListagemDTO>> listarTikets() {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para listagem de tickets");
        return ResponseEntity.ok().body(ticketService.recurperarTodosTicketsDTO());
    }

    @GetMapping(value = "/tickets/{id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Ticket> listarTikets(@PathVariable(name = "id")Integer idTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para recuperar dados de ticket "+idTicket);
        return ResponseEntity.ok().body(ticketService.recuperarTicketPorId(idTicket));
    }
    
    @PostMapping(value = "/tickets",produces = "application/json;charset=UTF-8")
    public ResponseEntity<URI> postMethodName(@Validated @RequestBody TicketDTO novoTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para criação de ticket");
        Integer idNovoTicket = ticketService.criarTicket(novoTicket);
        URI uriNovoTicket = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idNovoTicket).toUri();
        return ResponseEntity.created(uriNovoTicket).body(uriNovoTicket);
    }

    @PutMapping(value = "/tickets/{idTicket}",produces="application/json;charset=UTF-8")
    public ResponseEntity<Ticket> putMethodName(@PathVariable Integer idTicket, @Validated @RequestBody TicketInsertDTO dadosAtualizadosTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para atualização do ticket "+idTicket);
        return ResponseEntity.ok().body(ticketService.atualizarTicket(dadosAtualizadosTicket, idTicket));
    }
    
}
