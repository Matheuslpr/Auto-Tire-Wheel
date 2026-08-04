package dev.matheus.core.gateway;

import dev.matheus.core.entities.Clientes;

import java.util.List;

public interface ClientesGateway {

    Clientes create( Clientes clientes);
    Clientes findById(Long id);
    Clientes replace(Clientes clientes);
    List<Clientes> findAll();
}
