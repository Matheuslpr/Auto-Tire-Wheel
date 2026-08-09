package dev.matheus.core.gateway;

import dev.matheus.core.entities.Funcionarios;

import java.util.List;

public interface FuncionariosGateway {

    Funcionarios create(Funcionarios funcionarios);
    Funcionarios findById(Long id);
    Funcionarios replace(Funcionarios funcionarios);
    List<Funcionarios> findAll();
    Funcionarios delete(Long id);
}
