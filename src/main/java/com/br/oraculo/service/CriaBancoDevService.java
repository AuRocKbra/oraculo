package com.br.oraculo.service;

import org.springframework.stereotype.Service;

import com.br.oraculo.domain.Categoria;
import com.br.oraculo.domain.Ticket;

@Service
public class CriaBancoDevService {

    private TicketService ticketService;
    private CategoriaService categoriaService;
    
    public CriaBancoDevService( TicketService ticketService, CategoriaService categoriaService){
        this.ticketService = ticketService;
        this.categoriaService = categoriaService;
    }

    public void criarTicketsExemplos(){
        Categoria categoria1 = new Categoria("Aplicação","CAT.1");
        Categoria categoria2 = new Categoria("Banco de dados","CAT.2");
        Categoria categoria3 = new Categoria("Suporte usuário","CAT.3");
        Categoria categoria4 = new Categoria("Redes","CAT.4");

        categoriaService.criarCategoria(categoria1);
        categoriaService.criarCategoria(categoria2);
        categoriaService.criarCategoria(categoria3);
        categoriaService.criarCategoria(categoria4);

        Ticket ticketExemplo1 = new Ticket("Hoje pela manhão não consegui logar na minha máquina pois aparentemente meu usuário está bloqueado.",
                                             "Usuário bloqueado", categoriaService.recuperarCategoriaPorId(3));
        Ticket ticketExemplo2 = new Ticket("Gostaria de saber qual é o procedimento adotado para realização de cadastro de sistema e os dados necessários para realização do cadastro",
                                             "Dúvidas sober cadastro de sistemas", categoriaService.recuperarCategoriaPorId(1));
        Ticket ticketExemplo3 = new Ticket("Solicito a criação de pipeline de homologação para o sistema XPTO",
                                             "Criação de pipeline devops", categoriaService.recuperarCategoriaPorId(1));
        Ticket ticketExemplo4 = new Ticket("Estou abrindo este chamado de uma máquina de meu colega de trabalho pois minha máquina não está ligando",
                                             "Computador não liga", categoriaService.recuperarCategoriaPorId(3));
        Ticket ticketExemplo5 = new Ticket("Gostaria de saber se exeite alguma documentação sobre os serviços da api de documentos",
                                             "Documentação da api de documentos", categoriaService.recuperarCategoriaPorId(1));

        ticketService.criarTicket(ticketExemplo1);
        ticketService.criarTicket(ticketExemplo2);
        ticketService.criarTicket(ticketExemplo3);
        ticketService.criarTicket(ticketExemplo4);
        ticketService.criarTicket(ticketExemplo5);
    }
}
