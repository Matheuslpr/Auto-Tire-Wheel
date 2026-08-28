package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {

    boolean existsByNumeroDocumento(String numeroDocumento);

    Optional<FuncionariosEntity> findByNumeroDocumento(String numeroDocumento);
}
