package dev.matheus.core.gateway;

import dev.matheus.core.entities.Produtos;

import java.util.List;
import java.util.Optional;

public interface ProdutosGateway {

    Produtos create(Produtos produtos);
    Produtos findById(Long id);
    Produtos replace(Produtos produtos);
    List<Produtos> findAll();
    Produtos delete(Long id);
    Optional<Produtos> filtrarPorCodigo(String codigo);
    boolean existsByCodigo(String codigo);

}
