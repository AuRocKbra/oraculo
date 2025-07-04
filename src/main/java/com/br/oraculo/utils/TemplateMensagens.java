package com.br.oraculo.utils;

public class TemplateMensagens {

    private TemplateMensagens(){}

    /*
     * Mensagem de exceção
     */
    public static final String RECURSO_NAO_ENCONTRATO = "Desculpe mas o que você procura não pode ser encontrado! Talvez mais tarde ou informando outro valor para busca";
    public static final String ERRO_INTERNO = "Descuple algo deu errado e não conseguimos atender o seu pedido. Tente novamente mais tarde";
    public static final String REQUISICAO_ERRADA_NUMERO_TICKET = "Os dados de atualização do ticket não conferem, favor revizar a requisição";

    /*
     * Mensagem de informação de log
     */
    public static final String REQUISICAO_RECEBIDA = "Requisição recebida {}";
    public static final String INICIANDO_ROTINAS = "Iniciando {}";
    public static final String ERRO_ROTINA = "Erro ao realizar {}. Erro ->{}";
}
