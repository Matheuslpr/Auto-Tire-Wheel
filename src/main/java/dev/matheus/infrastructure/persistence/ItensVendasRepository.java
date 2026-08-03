package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensVendasRepository extends JpaRepository<ItensVendaEntity, Long> {
}
