package dev.matheus.core.gateway;

import dev.matheus.core.entities.Produtos;

import java.util.List;

public interface ProdutosGateway {

    Produtos create(Produtos produtos);
    Produtos findById(Long id);
    Produtos replace(Produtos produtos);
    List<Produtos> findAll();
    Produtos delete(Long id);

}
