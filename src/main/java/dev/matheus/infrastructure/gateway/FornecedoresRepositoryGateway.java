package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.gateway.FornecedoresGateway;
import dev.matheus.infrastructure.mapper.fornecedor.FornecedoresEntityMapper;
import dev.matheus.infrastructure.persistence.FornecedoresEntity;
import dev.matheus.infrastructure.persistence.FornecedoresRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FornecedoresRepositoryGateway implements FornecedoresGateway {

    private final FornecedoresRepository repository;
    private final FornecedoresEntityMapper entityMapper;

    public FornecedoresRepositoryGateway(FornecedoresRepository repository, FornecedoresEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Fornecedores create(Fornecedores fornecedores) {
        FornecedoresEntity entity = entityMapper.toEntity(fornecedores);
        FornecedoresEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Fornecedores findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Fornecedores replace(Fornecedores fornecedores) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(fornecedores)));
    }

    @Override
    public List<Fornecedores> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();

    }

    @Override
    public Fornecedores delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }
}
