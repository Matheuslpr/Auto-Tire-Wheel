package dev.matheus.infrastructure.mapper.funcionario;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FuncionariosCreateMapper {

    public FuncionariosCreateRequest toDto(Funcionarios funcionarios){
        return new FuncionariosCreateRequest(
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
                funcionarios.salario()
        );
    }

    public Funcionarios toEntity(FuncionariosCreateRequest create){
        return new Funcionarios(
                null,
                create.nome(),
                create.tipoDocumento(),
                create.numeroDocumento(),
                create.email(),
                create.telefone(),
                create.logradouro(),
                create.numero(),
                create.bairro(),
                create.cidade(),
                create.estado(),
                create.cep(),
                create.cargo(),
                create.salario(),
                LocalDateTime.now(),
                null
        );
    }
}
