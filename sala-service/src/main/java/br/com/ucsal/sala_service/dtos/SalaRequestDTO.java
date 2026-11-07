package br.com.ucsal.sala_service.dtos;

import br.com.ucsal.sala_service.enums.TipoSala;
import br.com.ucsal.sala_service.model.Sala;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaRequestDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,
        @NotNull(message = "A capacidade é obrigatória!")
        @Min(value = 1, message = "A capacidade deve ser maior que zero")
        Integer capacidade,
        @NotNull(message = "O tipo de sala é obrigatório")
        TipoSala tipoSala){
    }

