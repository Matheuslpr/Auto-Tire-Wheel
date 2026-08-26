package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarFornecedoresUseCaseImpl implements CadastrarFornecedoresUseCase {

    private final FornecedoresGateway gateway;

    public CadastrarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(Fornecedores fornecedores) {
        if (gateway.existsByNumeroDocumento(fornecedores.numeroDocumento())) {
            throw new DuplicateException("Já existe um fornecedor cadastrado com este número de documento");
        }
        return gateway.create(fornecedores);
    }
}
