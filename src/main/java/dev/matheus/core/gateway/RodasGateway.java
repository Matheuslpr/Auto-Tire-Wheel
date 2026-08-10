package dev.matheus.core.gateway;

import dev.matheus.core.entities.Rodas;

import java.util.List;

public interface RodasGateway {

    Rodas create(Rodas rodas);
    Rodas findById(Long id);
    Rodas replace(Rodas rodas);
    List<Rodas> findAll();
    Rodas delete(Long id);

}
