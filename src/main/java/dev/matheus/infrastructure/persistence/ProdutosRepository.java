package dev.matheus.infrastructure.persistence;

import dev.matheus.core.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {

    Optional<Produtos> findByCodigo(String codigo);

}
