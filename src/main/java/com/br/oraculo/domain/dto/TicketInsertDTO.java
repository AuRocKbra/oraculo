package com.br.oraculo.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TicketInsertDTO (
        @NotBlank(message = "O título do ticket deve ser preenchido") String titulo,
        @NotBlank(message = "O ticket deve conter uma descrição") String descricao,
        @Positive(message = "A categoria do ticket deve ter um valor positivo maior que zero") @NotNull(message = "O ticket deve ter pelo menos uma categoria") Integer categoria,
        @Positive(message = "O status do ticket deve ter um valor positivo maior que zero") @NotNull(message = "O ticket deve ter um status definido") Integer status
){}
