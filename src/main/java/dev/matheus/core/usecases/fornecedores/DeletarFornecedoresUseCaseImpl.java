package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;

public class DeletarFornecedoresUseCaseImpl implements DeletarFornecedoresUseCase {

    private final FornecedoresGateway gateway;

    public DeletarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(Long id) {
        return gateway.delete(id);
    }
}
