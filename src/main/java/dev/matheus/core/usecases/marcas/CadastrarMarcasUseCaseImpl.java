package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarMarcasUseCaseImpl implements  CadastrarMarcasUseCase{

    private final MarcasGateway gateway;

    public CadastrarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Marcas execute(Marcas marcas) {
        if (gateway.existsByNome(marcas.nome())) {
            throw new DuplicateException("Já existe uma marca cadastrada com este nome");
        }
        return gateway.create(marcas);
    }

}
