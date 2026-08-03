package dev.matheus.infrastructure.mapper.marca;

import dev.matheus.core.entities.Marcas;
import dev.matheus.infrastructure.dto.marca.MarcasCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MarcasCreateMapper {

    public MarcasCreateRequest toDto(Marcas marcas){
        return new MarcasCreateRequest(marcas.nome());
    }

    public Marcas toEntity(MarcasCreateRequest create){
        return new Marcas(
                null,
                create.nome(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}