package com.br.oraculo.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(
    @NotBlank(message = "É necessário informar o nome da categoria") String nomeCategoria,
    @NotBlank(message = "É necessário informar um código para a categoria") String codigoIdentificacaoCategoria
) {}
