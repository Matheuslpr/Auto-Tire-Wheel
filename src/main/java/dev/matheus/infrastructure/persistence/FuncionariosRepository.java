package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {
}
