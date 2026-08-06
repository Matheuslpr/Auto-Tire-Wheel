package dev.matheus.core.usecases.fornecedores;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;

import java.time.LocalDateTime;

public class AtualizarFornecedoresUseCaseImpl implements AtualizarFornecedoresUseCase {

    private final FornecedoresGateway gateway;

    public AtualizarFornecedoresUseCaseImpl(FornecedoresGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Fornecedores execute(Fornecedores fornecedores){
        var existente = gateway.findById(fornecedores.id());
        if(existente == null){
            throw new IllegalArgumentException("Fornecedores não encontrado");
        }
        return gateway.replace( new Fornecedores(
                existente.id(),
                fornecedores.razaoSocial(),
                fornecedores.nomeFantasia(),
                fornecedores.tipoDocumento(),
                fornecedores.numeroDocumento(),
                fornecedores.inscricaoEstadual(),
                fornecedores.nomeContato(),
                fornecedores.email(),
                fornecedores.telefone(),
                fornecedores.logradouro(),
                fornecedores.numero(),
                fornecedores.bairro(),
                fornecedores.cidade(),
                fornecedores.estado(),
                fornecedores.cep(),
                LocalDateTime.now(),
                LocalDateTime.now())
        );
    }
}
