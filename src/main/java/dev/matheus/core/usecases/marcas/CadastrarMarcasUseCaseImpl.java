package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;

public class CadastrarMarcasUseCaseImpl implements  CadastrarMarcasUseCase{

    private final MarcasGateway gateway;

    public CadastrarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Marcas execute(Marcas marcas){
        return gateway.create(marcas);
    }

}
