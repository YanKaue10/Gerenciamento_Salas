package br.com.ucsal.sala_service.mapper;

import br.com.ucsal.sala_service.dtos.SalaRequestDTO;
import br.com.ucsal.sala_service.dtos.SalaResponseDTO;
import br.com.ucsal.sala_service.model.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {
    SalaResponseDTO toResponseDTO(Sala sala);
    List<SalaResponseDTO> toResponseDTOList(List<Sala> salas);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadoSala", ignore = true)
    Sala toEntity(SalaRequestDTO requestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadoSala", ignore = true)
    void updateEntityFromDto(SalaRequestDTO requestDTO, @MappingTarget Sala sala);
}
