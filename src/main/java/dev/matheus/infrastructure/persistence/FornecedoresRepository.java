package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Long> {
    boolean existsByNumeroDocumento(String numeroDocumento);
    Optional<FornecedoresEntity> findByNumeroDocumento(String numeroDocumento);
}
