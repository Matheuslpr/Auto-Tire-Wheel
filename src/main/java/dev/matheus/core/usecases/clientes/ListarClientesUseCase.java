package dev.matheus.core.usecases.clientes;

import dev.matheus.core.entities.Clientes;

import java.util.List;

public interface ListarClientesUseCase {
    List<Clientes> execute();
}
