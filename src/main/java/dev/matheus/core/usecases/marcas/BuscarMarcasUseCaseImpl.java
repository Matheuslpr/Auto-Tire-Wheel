package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class BuscarMarcasUseCaseImpl implements BuscarMarcasUseCase{

    private final MarcasGateway gateway;

    public BuscarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Marcas execute(Long id){
        var marcas = gateway.findById(id);
        if(marcas == null){
            throw  new ResourceNotFoundException("marca não encontrada");
        }
        return marcas;
    }

}
