package dev.matheus.core.gateway;

import dev.matheus.core.entities.Marcas;

import java.util.List;

public interface MarcasGateway {

    Marcas create(Marcas marcas);
    Marcas findById(Long id);
    Marcas replace(Marcas marcas);
    List<Marcas> findAll();
    Marcas delete(Long id);
}
