package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class FiltrarDocumentoClientesUsecaseImpl implements FiltrarDocumentoClientesUsecase {

    public final ClientesGateway gateway;

    public FiltrarDocumentoClientesUsecaseImpl(ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Clientes execute(String numeroDocumento) {
        return gateway.filtrarPorDocumento(numeroDocumento)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com documento: " + numeroDocumento + " não encontrado."));
    }
}
