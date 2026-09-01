package dev.matheus.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {

    Optional<ProdutosEntity> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

}
