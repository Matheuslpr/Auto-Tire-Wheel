package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.gateway.MarcasGateway;
import dev.matheus.infrastructure.mapper.marca.MarcasEntityMapper;
import dev.matheus.infrastructure.persistence.MarcasEntity;
import dev.matheus.infrastructure.persistence.MarcasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcasRepositoryGateway implements MarcasGateway {

    private final MarcasRepository repository;
    private final MarcasEntityMapper entityMapper;

    public MarcasRepositoryGateway(MarcasRepository repository, MarcasEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Marcas create(Marcas marcas) {
        MarcasEntity entity = entityMapper.toEntity(marcas);
        MarcasEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Marcas findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Marcas replace(Marcas marcas) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(marcas)));
    }

    @Override
    public List<Marcas> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();

    }

    @Override
    public Marcas delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }
}
