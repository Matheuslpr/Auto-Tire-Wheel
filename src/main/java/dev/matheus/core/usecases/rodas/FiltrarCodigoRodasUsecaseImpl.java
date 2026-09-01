package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarCodigoRodasUsecaseImpl implements FiltrarCodigoRodasUsecase {

    private final RodasGateway gateway;

    public FiltrarCodigoRodasUsecaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(String codigo) {
         return gateway.filtrarPorCodigo(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Rodas com código: " + codigo + " não encontrado."));
    }
}
