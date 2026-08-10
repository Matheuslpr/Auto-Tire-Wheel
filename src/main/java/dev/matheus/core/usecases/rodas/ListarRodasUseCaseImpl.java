package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;

import java.util.List;

public class ListarRodasUseCaseImpl implements ListarRodasUseCase{

    private final RodasGateway gateway;

    public ListarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Rodas> execute(){
        return gateway.findAll();
    }
}
