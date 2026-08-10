package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;

public class DeletarRodasUseCaseImpl implements DeletarRodasUseCase{

    private final RodasGateway gateway;

    public DeletarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Long id){
        return gateway.delete(id);
    }
}
