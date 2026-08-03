package dev.matheus.infrastructure.mapper.marca;

import dev.matheus.core.entities.Marcas;
import dev.matheus.infrastructure.dto.marca.MarcasRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MarcasUpdateMapper {

    public MarcasRequest toDto(Marcas marcas) {
        return new MarcasRequest(marcas.nome());
    }

    public Marcas merge(Marcas marcasExistente, MarcasRequest request){
        return new Marcas(
                marcasExistente.id(),
                request.nome() != null ? request.nome() : marcasExistente.nome(),
                marcasExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Marcas toEntity(MarcasRequest request){
        return new Marcas(
                null,
                request.nome(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
