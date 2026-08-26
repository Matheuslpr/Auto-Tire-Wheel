package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class BuscarRodasUseCaseImpl implements BuscarRodasUseCase{

    private final RodasGateway gateway;

    public BuscarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Long id) {
        var roda = gateway.findById(id);
        if (roda == null) {
            throw new ResourceNotFoundException("Roda não encontrada");
        }
        return roda;
    }

}
