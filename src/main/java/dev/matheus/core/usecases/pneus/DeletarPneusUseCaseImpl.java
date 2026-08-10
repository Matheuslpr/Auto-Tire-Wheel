package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;

public class DeletarPneusUseCaseImpl implements DeletarPneusUseCase {

    private final PneusGateway gateway;

    public DeletarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(Long id){
        return gateway.delete(id);
    }
}
