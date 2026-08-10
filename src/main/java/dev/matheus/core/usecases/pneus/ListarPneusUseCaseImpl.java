package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;

import java.util.List;

public class ListarPneusUseCaseImpl implements ListarPneusUseCase{

    private final PneusGateway gateway;

    public ListarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Pneus> execute(){
        return gateway.findAll();
    }
}
