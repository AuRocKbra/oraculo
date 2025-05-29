package com.br.oraculo.domain.dto;

import com.br.oraculo.domain.Categoria;
import jakarta.validation.constraints.*;

public record TicketDTO(
    @NotBlank(message = "O título do ticket deve ser preenchido") String titulo,
    @NotBlank(message = "O ticket deve conter uma descrição") String descricao,
    @NotBlank(message = "O ticket deve conter uma categoria") Categoria categoria
) {}
