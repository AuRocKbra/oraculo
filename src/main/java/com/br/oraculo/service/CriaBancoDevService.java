package com.br.oraculo.service;

import org.springframework.stereotype.Service;

import com.br.oraculo.domain.Ticket;

@Service
public class CriaBancoDevService {

    private TicketService ticketService;
    
    public CriaBancoDevService( TicketService ticketService){
        this.ticketService = ticketService;
    }

    public void criarTicketsExemplos(){
        Ticket ticketExemplo1 = new Ticket("Hoje pela manhão não consegui logar na minha máquina pois aparentemente meu usuário está bloqueado.",
                                             null, "Usuário bloqueado", null);
        Ticket ticketExemplo2 = new Ticket("Gostaria de saber qual é o procedimento adotado para realização de cadastro de sistema e os dados necessários para realização do cadastro",
                                             null, "Dúvidas sober cadastro de sistemas", null);
        Ticket ticketExemplo3 = new Ticket("Solicito a criação de pipeline de homologação para o sistema XPTO",
                                             null, "Criação de pipeline devops", null);
        Ticket ticketExemplo4 = new Ticket("Estou abrindo este chamado de uma máquina de meu colega de trabalho pois minha máquin não está ligando",
                                             null, "Computador não liga", null);
        Ticket ticketExemplo5 = new Ticket("Gostaria de saber se exeite alguma documentação sobre os serviços da api de documentos",
                                             null, "Documentação da api de documentos", null);
    }
}
