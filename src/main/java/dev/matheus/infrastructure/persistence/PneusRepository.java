package dev.matheus.infrastructure.persistence;

import dev.matheus.core.entities.Pneus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PneusRepository extends JpaRepository<PneusEntity, Long> {

    Optional<Pneus> findByCodigo(String codigo);


}
