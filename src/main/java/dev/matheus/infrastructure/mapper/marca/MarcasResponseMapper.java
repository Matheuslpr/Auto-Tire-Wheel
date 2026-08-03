package dev.matheus.infrastructure.mapper.marca;

import dev.matheus.core.entities.Marcas;
import dev.matheus.infrastructure.dto.marca.MarcasResponse;
import org.springframework.stereotype.Component;

@Component
public class MarcasResponseMapper {

    public MarcasResponse toDto(Marcas marcas) {
        return new MarcasResponse(
                marcas.id(),
                marcas.nome(),
                marcas.dataCadastro(),
                marcas.dataAtualizacao()
        );
    }

    public static Marcas toEntity(MarcasResponse response) {
        return new Marcas(
                response.id(),
                response.nome(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}
