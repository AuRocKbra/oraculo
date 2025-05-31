package com.br.oraculo.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.beans.XMLEncoder;

public record ComentarioDTO(
        @NotBlank(message = "O comentário deve ter pelo menos uma descrição") String descricao,
        @Positive(message = "O comentário deve ter um responsável") @Min(value = 1, message = "O código do usuário deve ser maior que zero") Integer codigoUsuario,
        @Positive(message = "O comentário deve pertecer a um ticket e somente 1") @Min(value = 1, message = "O código do ticket deve ser maior que zero") Integer codigoTicket
) {}
