package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;

public class BuscarRodasUseCaseImpl implements BuscarRodasUseCase{

    private final RodasGateway gateway;

    public BuscarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Long id) {
        var roda = gateway.findById(id);
        if (roda == null) {
            throw new IllegalArgumentException("Roda não encontrada");
        }
        return roda;
    }

}
