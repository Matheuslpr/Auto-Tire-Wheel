package dev.matheus.infrastructure.mapper.roda;

import dev.matheus.core.entities.Rodas;
import dev.matheus.infrastructure.dto.roda.RodasCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RodasCreateMapper {

    public RodasCreateRequest toDto(Rodas rodas){
        return new RodasCreateRequest(
                rodas.marcaId(),
                rodas.codigo(),
                rodas.nome(),
                rodas.aro(),
                rodas.larguraPolegadas(),
                rodas.furos(),
                rodas.diametroFuracaoMm(),
                rodas.offsetEtMm(),
                rodas.material(),
                rodas.corAcabamento(),
                rodas.precoCusto(),
                rodas.precoVenda(),
                rodas.estoque()
        );
    }

    public Rodas toEntity(RodasCreateRequest create){
        return new Rodas(
                null,
                create.marcaId(),
                create.codigo(),
                create.nome(),
                create.aro(),
                create.larguraPolegadas(),
                create.furos(),
                create.diametroFuracaoMm(),
                create.offsetEtMm(),
                create.material(),
                create.corAcabamento(),
                create.precoCusto(),
                create.precoVenda(),
                create.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
