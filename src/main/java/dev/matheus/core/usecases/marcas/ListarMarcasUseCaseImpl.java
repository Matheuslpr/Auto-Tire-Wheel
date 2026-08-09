package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;

import java.util.List;

public class ListarMarcasUseCaseImpl implements ListarMarcasUseCase{

    private final MarcasGateway gateway;

    public ListarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Marcas> execute(){
        return gateway.findAll();
    }

}
