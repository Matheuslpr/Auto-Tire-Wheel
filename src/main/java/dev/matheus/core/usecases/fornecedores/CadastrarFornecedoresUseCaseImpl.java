package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;

public class CadastrarFornecedoresUseCaseImpl implements CadastrarFornecedoresUseCase {

    private final FornecedoresGateway gateway;

    public CadastrarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(Fornecedores fornecedores){
        return gateway.create(fornecedores);
    }
}
