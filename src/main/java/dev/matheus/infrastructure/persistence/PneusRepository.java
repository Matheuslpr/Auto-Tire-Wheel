package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PneusRepository extends JpaRepository<PneusEntity, Long> {

    Optional<PneusEntity> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

}
