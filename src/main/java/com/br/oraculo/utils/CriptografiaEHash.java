package com.br.oraculo.utils;

import com.br.oraculo.exception.ErroInternoException;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Slf4j
public class CriptografiaEHash {
    private CriptografiaEHash(){}

    public static final String calculaHashSenhaHexaDecimal(String senha){
        log.info(TemplateMensagens.INICIANDO_ROTINAS,"rotina de calculo de hash de senhas");
        try{
            StringBuilder hashSenhaCaculadaEmHexa = new StringBuilder();
            MessageDigest metodoCalculoHash = MessageDigest.getInstance("SHA3-512");
            byte[] hashSenha = metodoCalculoHash.digest(senha.getBytes(StandardCharsets.UTF_8));
            for(byte byteSenha: hashSenha){
                hashSenhaCaculadaEmHexa.append(String.format("%02x",byteSenha));
            }
            return hashSenhaCaculadaEmHexa.toString();
        }catch (Exception e){
            log.error(TemplateMensagens.ERRO_ROTINA,"calculo de hash da senha",e.getMessage());
            throw new ErroInternoException(TemplateMensagens.ERRO_INTERNO,new Throwable("ERRO-CAL-HAXE-USR"));
        }
    }
}
