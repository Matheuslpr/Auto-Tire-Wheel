package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;

public interface BuscarFuncionariosUseCase {
    Funcionarios execute(Long id);

}
