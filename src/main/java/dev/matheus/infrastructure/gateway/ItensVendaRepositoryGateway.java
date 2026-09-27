package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.enuns.TipoItemVenda;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.infrastructure.mapper.itemVenda.ItensVendaEntityMapper;
import dev.matheus.infrastructure.persistence.ItensVendaEntity;
import dev.matheus.infrastructure.persistence.ItensVendasRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItensVendaRepositoryGateway implements ItensVendaGateway {

    private final ItensVendasRepository repository;
    private final ItensVendaEntityMapper entityMapper;

    public ItensVendaRepositoryGateway(ItensVendasRepository repository, ItensVendaEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public ItensVenda create(ItensVenda itensVenda) {
        ItensVendaEntity entity = entityMapper.toEntity(itensVenda);
        ItensVendaEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public ItensVenda findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public ItensVenda replace(ItensVenda itensVenda) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(itensVenda)));
    }

    @Override
    public List<ItensVenda> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();

    }

    @Override
    public ItensVenda delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }

    @Override
    public boolean existsDuplicado(Long vendaId, TipoItemVenda tipoItem, Long itemId) {
        return repository.existsByVendaIdAndTipoItemAndItemId(vendaId, tipoItem, itemId);
    }

    @Override
    public List<ItensVenda> findByVendaId(Long vendaId) {
        return repository.findByVendaId(vendaId)
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }
}
