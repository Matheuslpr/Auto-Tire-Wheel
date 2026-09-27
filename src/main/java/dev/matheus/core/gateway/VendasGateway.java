package dev.matheus.core.gateway;

import dev.matheus.core.entities.Vendas;

import java.util.List;

public interface VendasGateway {

    Vendas create(Vendas vendas);
    Vendas findById(Long id);
    Vendas replace(Vendas vendas);
    List<Vendas> findAll();
    Vendas delete(Long id);

}
