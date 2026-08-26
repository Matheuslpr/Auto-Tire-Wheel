package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class BuscarFornecedoresUseCaseImpl implements BuscarFornecedoresUseCase{

    private final FornecedoresGateway gateway;

    public BuscarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(Long id){
        var fornecedor = gateway.findById(id);
        if (fornecedor == null){
            throw new ResourceNotFoundException("Fornecedor não encontrado");
        }
        return fornecedor;
    }
}
