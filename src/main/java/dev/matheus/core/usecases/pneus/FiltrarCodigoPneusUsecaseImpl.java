package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarCodigoPneusUsecaseImpl implements FiltrarCodigoPneusUsecase {

    private final PneusGateway gateway;

    public FiltrarCodigoPneusUsecaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(String codigo) {
         return gateway.filtrarPorCodigo(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Pneu com código: " + codigo + " não encontrado."));
    }
}
