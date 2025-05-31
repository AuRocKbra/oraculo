package com.br.oraculo.service;

import com.br.oraculo.domain.Comentario;
import com.br.oraculo.domain.Ticket;
import com.br.oraculo.domain.Usuario;
import com.br.oraculo.domain.dto.ComentarioDTO;
import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.repository.ComentarioRepository;
import com.br.oraculo.utils.TemplateMensagens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ComentarioService {

    private ComentarioRepository comentarioRepository;
    private TicketService ticketService;
    private UsuarioService usuarioService;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             TicketService ticketService,
                             UsuarioService usuarioService){
        this.comentarioRepository = comentarioRepository;
        this.ticketService = ticketService;
        this.usuarioService = usuarioService;
    }

    public Comentario criarComentario(ComentarioDTO dadosNovoComentario){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"serviço de criação de comentário do ticket");
        Ticket ticket = ticketService.recuperarTicketPorId(dadosNovoComentario.codigoTicket());
        Usuario usuario = usuarioService.resuperaUsuarioPorId(dadosNovoComentario.codigoUsuario());
        Comentario novoComentario = new Comentario(dadosNovoComentario.descricao(),ticket,usuario);
        try{
            return comentarioRepository.save(novoComentario);
        }catch (Exception e){
            log.error(TemplateMensagens.ERRO_ROTINA,"o cadastro do comentário",e.getCause());
            throw new ErroInternoException(TemplateMensagens.ERRO_INTERNO,new Throwable("ERRO-CAD-COM"));
        }
    }
}
