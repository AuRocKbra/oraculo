package com.br.oraculo.resource;

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
    public ResponseEntity<List<Ticket>> listarTikets() {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para listagem de tickets");
        return ResponseEntity.ok().body(ticketService.recurperarTodosTickets());
    }

    @GetMapping(value = "/tickets/{id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Ticket> listarTikets(@PathVariable(name = "id")Long idTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para recuperar dados de ticket "+idTicket);
        return ResponseEntity.ok().body(ticketService.recuperaTicketPorId(idTicket));
    }
    
    @PostMapping(value = "/tickets",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ResponseEntity<URI> postMethodName(@RequestBody TicketDTO novoTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para criação de ticket");
        Integer idNovoTicket = ticketService.criarTicket(new Ticket(novoTicket.descricao(), novoTicket.titulo(), novoTicket.categoria()));
        URI uriNovoTicket = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idNovoTicket).toUri();
        return ResponseEntity.created(uriNovoTicket).build();
    }

    @PutMapping(value = "/tickets/{idTicket}",produces="application/json;charset=UTF-8")
    public ResponseEntity<Ticket> putMethodName(@PathVariable Long idTicket, @RequestBody TicketDTO dadosAtualizadosTicket) {
        log.info(TemplateMensagens.REQUISICAO_RECEBIDA,"para atualização do ticket "+idTicket);
        return ResponseEntity.ok().body(ticketService.atualizarTicket(dadosAtualizadosTicket, idTicket));
    }
    
}
