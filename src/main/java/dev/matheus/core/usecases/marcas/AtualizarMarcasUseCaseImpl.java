package dev.matheus.core.usecases.marcas;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;

import java.time.LocalDateTime;

public class AtualizarMarcasUseCaseImpl implements AtualizarMarcasUseCase {

    private final MarcasGateway gateway;

    public AtualizarMarcasUseCaseImpl(MarcasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Marcas execute(Marcas marcas){

        var existente = gateway.findById(marcas.id());
        if (existente == null) {
            throw new IllegalArgumentException("Marca não encontrada");
        }
        return gateway.replace(new Marcas(
                existente.id(),
                marcas.nome(),
                existente.dataCadastro(),
                LocalDateTime.now()
        ));
    }
}
