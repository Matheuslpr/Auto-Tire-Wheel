package dev.matheus.core.gateway;

import dev.matheus.core.entities.Pneus;

import java.util.List;
import java.util.Optional;

public interface PneusGateway {

    Pneus create(Pneus pneus);
    Pneus findById(Long id);
    Pneus replace(Pneus pneus);
    List<Pneus> findAll();
    Pneus delete(Long id);
    Optional<Pneus> filtrarPorCodigo(String codigo);

}
