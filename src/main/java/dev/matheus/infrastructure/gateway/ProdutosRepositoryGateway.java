package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.gateway.ProdutosGateway;
import dev.matheus.infrastructure.mapper.produto.ProdutosEntityMapper;
import dev.matheus.infrastructure.persistence.ProdutosEntity;
import dev.matheus.infrastructure.persistence.ProdutosRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutosRepositoryGateway implements ProdutosGateway {

    private final ProdutosRepository repository;
    private final ProdutosEntityMapper entityMapper;

    public ProdutosRepositoryGateway(ProdutosRepository repository, ProdutosEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Produtos create(Produtos produtos) {
        ProdutosEntity entity = entityMapper.toEntity(produtos);
        ProdutosEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Produtos findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Produtos replace(Produtos produtos) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(produtos)));
    }

    @Override
    public List<Produtos> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

    @Override
    public Produtos delete(Long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return entityMapper.toDomain(entity);
                })
                .orElse(null);
    }

    @Override
    public Optional<Produtos> filtrarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }
}