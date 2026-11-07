package br.com.ucsal.sala_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ucsal.sala_service.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, UUID> {

}
