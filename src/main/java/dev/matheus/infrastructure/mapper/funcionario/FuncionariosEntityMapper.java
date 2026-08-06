package dev.matheus.infrastructure.mapper.funcionario;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.infrastructure.persistence.FuncionariosEntity;
import org.springframework.stereotype.Component;

@Component
public class FuncionariosEntityMapper {

    public FuncionariosEntity toEntity(Funcionarios funcionarios) {
        FuncionariosEntity entity = new FuncionariosEntity();

        entity.setId(funcionarios.id());
        entity.setNome(funcionarios.nome());
        entity.setTipoDocumento(funcionarios.tipoDocumento());
        entity.setNumeroDocumento(funcionarios.numeroDocumento());
        entity.setEmail(funcionarios.email());
        entity.setTelefone(funcionarios.telefone());
        entity.setLogradouro(funcionarios.logradouro());
        entity.setNumero(funcionarios.numero());
        entity.setBairro(funcionarios.bairro());
        entity.setCidade(funcionarios.cidade());
        entity.setEstado(funcionarios.estado());
        entity.setCep(funcionarios.cep());
        entity.setCargo(funcionarios.cargo());
        entity.setSalario(funcionarios.salario());
        entity.setDataAdmissao(funcionarios.dataAdmissao());
        entity.setDataDesligamento(funcionarios.dataDesligamento());

        return entity;
    }

    public Funcionarios toDomain(FuncionariosEntity funcionarios) {
        return new Funcionarios(
                funcionarios.getId(),
                funcionarios.getNome(),
                funcionarios.getTipoDocumento(),
                funcionarios.getNumeroDocumento(),
                funcionarios.getEmail(),
                funcionarios.getTelefone(),
                funcionarios.getLogradouro(),
                funcionarios.getNumero(),
                funcionarios.getBairro(),
                funcionarios.getCidade(),
                funcionarios.getEstado(),
                funcionarios.getCep(),
                funcionarios.getCargo(),
                funcionarios.getSalario(),
                funcionarios.getDataAdmissao(),
                funcionarios.getDataDesligamento()
        );
    }
}
