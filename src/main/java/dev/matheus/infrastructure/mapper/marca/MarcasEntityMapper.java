package dev.matheus.infrastructure.mapper.marca;

import dev.matheus.core.entities.Marcas;
import dev.matheus.infrastructure.persistence.MarcasEntity;
import org.springframework.stereotype.Component;

@Component
public class MarcasEntityMapper {

    public MarcasEntity toEntity(Marcas marcas) {
        MarcasEntity entity = new MarcasEntity();

        entity.setId(marcas.id());
        entity.setNome(marcas.nome());
        entity.setDataCadastro(marcas.dataCadastro());
        entity.setDataAtualizacao(marcas.dataAtualizacao());

        return entity;
    }

    public Marcas toDomain(MarcasEntity marcas) {
        return new Marcas(
                marcas.getId(),
                marcas.getNome(),
                marcas.getDataCadastro(),
                marcas.getDataAtualizacao()
        );
    }
}
