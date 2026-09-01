package dev.matheus.core.gateway;

import dev.matheus.core.entities.Rodas;

import java.util.List;
import java.util.Optional;

public interface RodasGateway {

    Rodas create(Rodas rodas);
    Rodas findById(Long id);
    Rodas replace(Rodas rodas);
    List<Rodas> findAll();
    Rodas delete(Long id);
    Optional<Rodas> filtrarPorCodigo(String codigo);
    boolean existsByCodigo(String codigo);

}
