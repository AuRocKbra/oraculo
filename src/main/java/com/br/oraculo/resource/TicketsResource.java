package com.br.oraculo.resource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import com.br.oraculo.domain.Ticket;
import com.br.oraculo.service.TicketService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class TicketsResource {

    private TicketService ticketService;

    public TicketsResource(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/tickets",produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Ticket>> listarTikets() {
        return ResponseEntity.ok().body(ticketService.recurperarTodosTickets());
    }

    @GetMapping(value = "/tickets/{id}",produces = "application/json;charset=UTF-8")
    public ResponseEntity<Ticket> listarTikets(@PathVariable(name = "id")Long idTicket) {
        return ResponseEntity.ok().body(ticketService.recuperaTicketPorId(idTicket));
    }
    
    @PostMapping("/tickets")
    public ResponseEntity<URI> postMethodName(@RequestBody Ticket notoTicket) {
        Long idNovoTicket = ticketService.criarTicket(notoTicket);
        URI uriNovoTicket = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idNovoTicket).toUri();
        return ResponseEntity.created(uriNovoTicket).build();
    }
    
}
