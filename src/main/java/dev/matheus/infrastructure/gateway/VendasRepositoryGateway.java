package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.mapper.venda.VendasEntityMapper;
import dev.matheus.infrastructure.persistence.VendasEntity;
import dev.matheus.infrastructure.persistence.VendasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendasRepositoryGateway implements VendasGateway {

    private final VendasRepository repository;
    private final VendasEntityMapper entityMapper;

    public VendasRepositoryGateway(VendasRepository repository, VendasEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Vendas create(Vendas vendas) {
        VendasEntity entity = entityMapper.toEntity(vendas);
        VendasEntity savedEntity = repository.save(entity);
        return VendasEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Vendas findById(Long id) {
        return repository.findById(id)
                .map(VendasEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Vendas replace(Vendas vendas) {
        return VendasEntityMapper.toDomain(repository.save(entityMapper.toEntity(vendas)));
    }

    @Override
    public List<Vendas> findAll() {
        return repository.findAll()
                .stream()
                .map(VendasEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Vendas delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return VendasEntityMapper.toDomain(entity);
                })
                .orElse(null);
    }
}