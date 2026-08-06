package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;

import java.util.List;

public class ListarFornecedoresUseCaseImpl implements ListarFornecedoresUseCase {

    private final FornecedoresGateway gateway;

    public ListarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Fornecedores> execute() {
        return gateway.findAll();
    }

}
