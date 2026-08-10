package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.mapper.roda.RodasEntityMapper;
import dev.matheus.infrastructure.persistence.RodasEntity;
import dev.matheus.infrastructure.persistence.RodasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RodasRepositoryGateway implements RodasGateway {

    private final RodasRepository repository;
    private final RodasEntityMapper entityMapper;

    public RodasRepositoryGateway(RodasRepository repository, RodasEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Rodas create(Rodas rodas) {
        RodasEntity entity = entityMapper.toEntity(rodas);
        RodasEntity savedEntity = repository.save(entity);
        return RodasEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Rodas findById(Long id) {
        return repository.findById(id)
                .map(RodasEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Rodas replace(Rodas rodas) {
        return RodasEntityMapper.toDomain(repository.save(entityMapper.toEntity(rodas)));
    }

    @Override
    public List<Rodas> findAll() {
        return repository.findAll()
                .stream()
                .map(RodasEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Rodas delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return RodasEntityMapper.toDomain(entity);
                })
                .orElse(null);
    }
}