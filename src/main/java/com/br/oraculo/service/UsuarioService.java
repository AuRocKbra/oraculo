package com.br.oraculo.service;

import com.br.oraculo.domain.Usuario;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.UsuarioRepository;
import com.br.oraculo.utils.TemplateMensagens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario resuperaUsuarioPorId(Integer codigoUsuario){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"serviço de consulta de usuário");
        return usuarioRepository.findById(codigoUsuario).orElseThrow(()->new RecursoNaoEncontradoException(TemplateMensagens.RECURSO_NAO_ENCONTRATO));
    }
}
