package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.infrastructure.mapper.pneu.PneusEntityMapper;
import dev.matheus.infrastructure.persistence.PneusEntity;
import dev.matheus.infrastructure.persistence.PneusRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PneusRepositoryGateway implements PneusGateway {

    private final PneusRepository repository;
    private final PneusEntityMapper entityMapper;

    public PneusRepositoryGateway(PneusRepository repository, PneusEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Pneus create(Pneus pneus) {
        PneusEntity entity = entityMapper.toEntity(pneus);
        PneusEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Pneus findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Pneus replace(Pneus pneus) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(pneus)));
    }

    @Override
    public List<Pneus> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public Pneus delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }

    @Override
    public Optional<Pneus> filtrarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo)
                .map(entityMapper::toDomain);
    }

    @Override
    public boolean existsByCodigo(String codigo) {
        return repository.existsByCodigo(codigo);
    }
}
