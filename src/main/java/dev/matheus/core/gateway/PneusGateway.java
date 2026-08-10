package dev.matheus.core.gateway;

import dev.matheus.core.entities.Pneus;

import java.util.List;

public interface PneusGateway {

    Pneus create(Pneus pneus);
    Pneus findById(Long id);
    Pneus replace(Pneus pneus);
    List<Pneus> findAll();
    Pneus delete(Long id);
}
