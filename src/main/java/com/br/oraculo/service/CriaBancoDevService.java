package com.br.oraculo.service;

import com.br.oraculo.domain.dto.TicketDTO;
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
        Categoria categoria1 = new Categoria("Dúvida","CAT.1");
        Categoria categoria2 = new Categoria("Atualização","CAT.2");
        Categoria categoria3 = new Categoria("Correção de bug","CAT.3");
        Categoria categoria4 = new Categoria("Nova função","CAT.4");
        Categoria categoria5 = new Categoria("Configuração DevOps","CAT.5");

        categoriaService.criarCategoria(categoria1);
        categoriaService.criarCategoria(categoria2);
        categoriaService.criarCategoria(categoria3);
        categoriaService.criarCategoria(categoria4);
        categoriaService.criarCategoria(categoria5);

        Ticket ticketExemplo1 = new Ticket("Hoje pela manhã não consegui logar na aplicação XPTO. Sempre que digitava o usuário e senha a mensagem de usuário e senha inválidos esta apresentada, porém ambos os dados estão corretos",
                                             "Erro na autenticação", categoriaService.recuperarCategoriaPorId(3));
        Ticket ticketExemplo2 = new Ticket("Gostaria de saber qual é o procedimento adotado para realização de cadastro de um novo sistema e os dados necessários para realização do cadastro.",
                                             "Dúvidas sober cadastro de novo sistema", categoriaService.recuperarCategoriaPorId(4));
        Ticket ticketExemplo3 = new Ticket("Solicito a criação de pipeline de homologação para o sistema XPTO.",
                                             "Criação de pipeline devops", categoriaService.recuperarCategoriaPorId(5));
        Ticket ticketExemplo4 = new Ticket("Atualização a aplicação XYZ para disponibilização de uma nova função.",
                                             "Atualização da aplicação XYZ", categoriaService.recuperarCategoriaPorId(2));
        Ticket ticketExemplo5 = new Ticket("Gostaria de saber se existe alguma documentação sobre os serviços da api de documentos.",
                                             "Documentação da api de documentos", categoriaService.recuperarCategoriaPorId(1));

        ticketService.criarTicket(new TicketDTO(ticketExemplo1.getTitulo(),ticketExemplo1.getDescricao(),ticketExemplo1.getCategoria().getCodigoCategoria()));
        ticketService.criarTicket(new TicketDTO(ticketExemplo2.getTitulo(),ticketExemplo2.getDescricao(),ticketExemplo2.getCategoria().getCodigoCategoria()));
        ticketService.criarTicket(new TicketDTO(ticketExemplo3.getTitulo(),ticketExemplo3.getDescricao(),ticketExemplo3.getCategoria().getCodigoCategoria()));
        ticketService.criarTicket(new TicketDTO(ticketExemplo4.getTitulo(),ticketExemplo4.getDescricao(),ticketExemplo4.getCategoria().getCodigoCategoria()));
        ticketService.criarTicket(new TicketDTO(ticketExemplo5.getTitulo(),ticketExemplo5.getDescricao(),ticketExemplo5.getCategoria().getCodigoCategoria()));
    }
}
