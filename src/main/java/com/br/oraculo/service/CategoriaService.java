package com.br.oraculo.service;

import org.springframework.stereotype.Service;

import com.br.oraculo.domain.Categoria;
import com.br.oraculo.exception.RecursoNaoEncontradoException;
import com.br.oraculo.repository.CategoriaRepository;
import com.br.oraculo.utils.TemplateMensagens;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Integer criarCategoria(Categoria novaCategoria){
        return  categoriaRepository.save(novaCategoria).getCodigoCategoria();
    }

    public Categoria recuperarCategoriaPorId(Integer codigoCategoria){
        return categoriaRepository.findById(codigoCategoria).orElseThrow(()-> new RecursoNaoEncontradoException(TemplateMensagens.RECURSO_NAO_ENCONTRATO));
    }
}
