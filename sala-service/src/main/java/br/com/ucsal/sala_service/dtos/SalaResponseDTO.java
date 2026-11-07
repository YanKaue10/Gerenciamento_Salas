package br.com.ucsal.sala_service.dtos;

import java.util.UUID;

import br.com.ucsal.sala_service.enums.EstadoSala;
import br.com.ucsal.sala_service.enums.TipoSala;


public record SalaResponseDTO(
        UUID id,
        String nome,
        Integer capacidade,
        TipoSala tipoSala,
        EstadoSala estadoSala) {
}
