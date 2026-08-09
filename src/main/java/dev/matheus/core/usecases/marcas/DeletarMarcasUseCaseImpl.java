package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;

public class DeletarMarcasUseCaseImpl implements DeletarMarcasUseCase{

    private final MarcasGateway gateway;

    public DeletarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Marcas execute(Long id ){
        return gateway.delete(id);
    }

}
