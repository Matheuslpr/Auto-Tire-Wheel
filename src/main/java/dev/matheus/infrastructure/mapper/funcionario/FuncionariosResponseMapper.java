package dev.matheus.infrastructure.mapper.funcionario;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosResponse;
import org.springframework.stereotype.Component;

@Component
public class FuncionariosResponseMapper {

    public FuncionariosResponse toDto(Funcionarios funcionarios) {
        return new FuncionariosResponse(
                funcionarios.id(),
                funcionarios.nome(),
                funcionarios.tipoDocumento(),
                funcionarios.numeroDocumento(),
                funcionarios.email(),
                funcionarios.telefone(),
                funcionarios.logradouro(),
                funcionarios.numero(),
                funcionarios.bairro(),
                funcionarios.cidade(),
                funcionarios.estado(),
                funcionarios.cep(),
                funcionarios.cargo(),
                funcionarios.salario(),
                funcionarios.dataAdmissao(),
                funcionarios.dataDesligamento()
        );
    }

    public static Funcionarios toEntity(FuncionariosResponse response) {
        return new Funcionarios(
                response.id(),
                response.nome(),
                response.tipoDocumento(),
                response.numeroDocumento(),
                response.email(),
                response.telefone(),
                response.logradouro(),
                response.numero(),
                response.bairro(),
                response.cidade(),
                response.estado(),
                response.cep(),
                response.cargo(),
                response.salario(),
                response.dataAdmissao(),
                response.dataDesligamento()
        );
    }
}
