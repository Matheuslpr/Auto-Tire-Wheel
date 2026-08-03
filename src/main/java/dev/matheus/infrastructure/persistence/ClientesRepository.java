package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<ClientesEntity,Long> {
}
