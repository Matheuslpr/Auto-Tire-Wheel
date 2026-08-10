package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;

public class CadastrarPneusUseCaseImpl implements CadastrarPneusUseCase {

    private final PneusGateway gateway;

    public CadastrarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(Pneus pneus){
        return gateway.create(pneus);
    }
}
