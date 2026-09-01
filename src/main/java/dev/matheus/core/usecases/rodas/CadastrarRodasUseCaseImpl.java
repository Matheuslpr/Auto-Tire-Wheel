package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarRodasUseCaseImpl implements CadastrarRodasUseCase{

    private final RodasGateway gateway;

    public CadastrarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Rodas rodas) {
        if (gateway.existsByCodigo(rodas.codigo())) {
            throw new DuplicateException("Já existe uma roda cadastrada com este código");
        }
        return gateway.create(rodas);
    }
}
