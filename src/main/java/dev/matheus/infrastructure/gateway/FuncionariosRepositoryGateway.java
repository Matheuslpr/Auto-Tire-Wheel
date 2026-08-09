package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.infrastructure.mapper.funcionario.FuncionariosEntityMapper;
import dev.matheus.infrastructure.persistence.FornecedoresEntity;
import dev.matheus.infrastructure.persistence.FuncionariosEntity;
import dev.matheus.infrastructure.persistence.FuncionariosRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionariosRepositoryGateway implements FuncionariosGateway {

    private final FuncionariosRepository repository;
    private final FuncionariosEntityMapper entityMapper;

    public FuncionariosRepositoryGateway(FuncionariosRepository repository, FuncionariosEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Funcionarios create(Funcionarios funcionarios) {
        FuncionariosEntity entity = entityMapper.toEntity(funcionarios);
        FuncionariosEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Funcionarios findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Funcionarios replace(Funcionarios funcionarios) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(funcionarios)));
    }

    @Override
    public List<Funcionarios> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();

    }

    @Override
    public Funcionarios delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }
}
