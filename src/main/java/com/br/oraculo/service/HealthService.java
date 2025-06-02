package com.br.oraculo.service;

import com.br.oraculo.exception.ErroInternoException;
import com.br.oraculo.utils.TemplateMensagens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@Slf4j
public class HealthService {

    private CategoriaService categoriaService;

    public HealthService(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    public String consultaBancoUp(){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"serviço de verificação de saúde da aplicação");
        SimpleDateFormat formatar = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss");
        try {
            categoriaService.recuperarCategoriaPorId(1);
            return "Aplicação em execução "+formatar.format(new Date());
        }catch (Exception e){
            log.error(TemplateMensagens.ERRO_ROTINA,"verificação de uptime do sistema",e.getMessage());
            throw new ErroInternoException(TemplateMensagens.ERRO_INTERNO);
        }
    }
}
