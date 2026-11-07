package br.com.ucsal.sala_service.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ucsal.sala_service.dtos.SalaRequestDTO;
import br.com.ucsal.sala_service.dtos.SalaResponseDTO;
import br.com.ucsal.sala_service.service.SalaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarSalas() {
        return ResponseEntity.ok(salaService.listarSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(salaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> cadastrar(@RequestBody @Valid SalaRequestDTO salaRequestDTO) {
        SalaResponseDTO salaCriada = salaService.cadastrar(salaRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salaCriada.id())
                .toUri();
        return ResponseEntity.created(location).body(salaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> atualizar(@PathVariable UUID id,
                                                     @RequestBody @Valid SalaRequestDTO salaRequestDTO) {
        return ResponseEntity.ok(salaService.atualizar(id, salaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        salaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
