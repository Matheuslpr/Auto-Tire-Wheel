package dev.matheus.infrastructure.gateway;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.infrastructure.mapper.cliente.ClientesEntityMapper;
import dev.matheus.infrastructure.persistence.ClientesEntity;
import dev.matheus.infrastructure.persistence.ClientesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesRepositoryGateway implements ClientesGateway {

    private final ClientesRepository repository;
    private final ClientesEntityMapper entityMapper;

    public ClientesRepositoryGateway(ClientesRepository repository, ClientesEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Clientes create(Clientes clientes) {
        ClientesEntity entity = entityMapper.toEntity(clientes);
        ClientesEntity savedEntity = repository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }

    @Override
    public Clientes findById(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Clientes replace( Clientes clientes) {

        return entityMapper.toDomain(repository.save(entityMapper.toEntity(clientes)));
    }

    @Override
    public List<Clientes> findAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDomain)
                .toList();
    }

}
