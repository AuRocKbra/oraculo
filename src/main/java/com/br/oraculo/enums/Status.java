package com.br.oraculo.enums;

public enum Status {
    AGUARDANDO_ATENDIMENTO("Aguardando execução",1),
    EM_EXECUCAO("Em execução",2),
    CANCELADO("Cancelado",3),
    RESOLVIDO("Resolvido",4);

    private final String descricao;
    private final Integer codigoStatus;

    Status(String descricao, Integer codigoStatus){
        this.descricao = descricao;
        this.codigoStatus = codigoStatus;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Integer getCodigoStatus(){
        return this.codigoStatus;
    }
}
