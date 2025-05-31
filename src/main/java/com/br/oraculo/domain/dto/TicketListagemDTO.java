package com.br.oraculo.domain.dto;

import com.br.oraculo.domain.Categoria;
import com.br.oraculo.domain.Ticket;
import com.br.oraculo.enums.Status;
import lombok.Getter;

import java.util.List;

@Getter
public class TicketListagemDTO {
    private Integer idTicket;
    private String descricao;
    private String titulo;
    private Categoria categoria;
    private String status;

    public TicketListagemDTO(Ticket ticket){
        this.idTicket = ticket.getIdTicket();
        this.descricao = ticket.getDescricao();
        this.titulo = ticket.getTitulo();
        this.categoria = ticket.getCategoria();
        this.status = switch (ticket.getStatus()){
            case 1 -> Status.AGUARDANDO_ATENDIMENTO.getDescricao();
            case 2 -> Status.EM_EXECUCAO.getDescricao();
            case 3 -> Status.CANCELADO.getDescricao();
            default -> Status.RESOLVIDO.getDescricao();
        };
    }
}
