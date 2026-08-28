package dev.matheus.infrastructure.persistence;

import dev.matheus.core.entities.Rodas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RodasRepository extends JpaRepository<RodasEntity, Long> {

    Optional<Rodas> findByCodigo(String codigo);

}
