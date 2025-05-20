package com.br.oraculo.resource;

import org.springframework.web.bind.annotation.RestController;

import com.br.oraculo.domain.Ticket;
import com.br.oraculo.service.TicketService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    
}
