package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.infrastructure.exception.DuplicateException;

public class CadastrarPneusUseCaseImpl implements CadastrarPneusUseCase {

    private final PneusGateway gateway;

    public CadastrarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(Pneus pneus){
        if (gateway.existsByCodigo(pneus.codigo())) {
            throw new DuplicateException("Já existe um pneu cadastrado com este código");
        }
        return gateway.create(pneus);
    }

}
