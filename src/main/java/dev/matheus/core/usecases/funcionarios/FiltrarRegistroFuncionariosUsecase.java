package dev.matheus.core.usecases.funcionarios;

import dev.matheus.core.entities.Funcionarios;

public interface FiltrarRegistroFuncionariosUsecase {

    Funcionarios execute(String registro);
}
