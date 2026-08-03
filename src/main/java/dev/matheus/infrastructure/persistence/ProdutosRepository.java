package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
