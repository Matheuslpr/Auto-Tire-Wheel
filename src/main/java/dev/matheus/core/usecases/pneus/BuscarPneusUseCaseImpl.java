package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class BuscarPneusUseCaseImpl implements BuscarPneusUseCase{

    private final PneusGateway gateway;

    public BuscarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(Long id){
        var pneu = gateway.findById(id);
        if (pneu == null) {
            throw new ResourceNotFoundException("Pneu não encontrado");
        }
        return pneu;
    }

}
