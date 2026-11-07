package br.com.ucsal.sala_service.model;

import java.util.UUID;

import br.com.ucsal.sala_service.enums.EstadoSala;
import br.com.ucsal.sala_service.enums.TipoSala;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome da sala é obrigatório!")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "A capacidade deve ser informada")
    @Min(value = 1, message = "A capacidade deve ser maior que zero.")
    private Integer capacidade;

    @NotNull(message = "O tipo de sala é obrigatório!")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSala tipoSala;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSala estadoSala = EstadoSala.DISPONIVEL;

}
