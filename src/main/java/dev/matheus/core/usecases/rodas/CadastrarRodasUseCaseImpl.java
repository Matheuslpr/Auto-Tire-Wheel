package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;

public class CadastrarRodasUseCaseImpl implements CadastrarRodasUseCase{

    private final RodasGateway gateway;

    public CadastrarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Rodas rodas) {
        return gateway.create(rodas);
    }
}
