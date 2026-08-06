package dev.matheus.core.gateway;

import dev.matheus.core.entities.Fornecedores;

import java.util.List;

public interface FornecedoresGateway {

    Fornecedores create(Fornecedores fornecedores);
    Fornecedores findById(Long id);
    Fornecedores replace(Fornecedores fornecedores);
    List<Fornecedores> findAll();
    Fornecedores delete(Long id);
}
