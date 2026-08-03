package dev.matheus.infrastructure.mapper.roda;

import dev.matheus.core.entities.Rodas;
import dev.matheus.infrastructure.dto.roda.RodasRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RodasUpdateMapper {

    public RodasRequest toDto(Rodas rodas) {
        return new RodasRequest(
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

    public Rodas merge(Rodas rodasExistente, RodasRequest request){
        return new Rodas(
                rodasExistente.id(),
                request.marcaId() != null ? request.marcaId() : rodasExistente.marcaId(),
                request.codigo() != null ? request.codigo() : rodasExistente.codigo(),
                request.nome() != null ? request.nome() : rodasExistente.nome(),
                request.aro() != null ? request.aro() : rodasExistente.aro(),
                request.larguraPolegadas() != null ? request.larguraPolegadas() : rodasExistente.larguraPolegadas(),
                request.furos() != null ? request.furos() : rodasExistente.furos(),
                request.diametroFuracaoMm() != null ? request.diametroFuracaoMm() : rodasExistente.diametroFuracaoMm(),
                request.offsetEtMm() != null ? request.offsetEtMm() : rodasExistente.offsetEtMm(),
                request.material() != null ? request.material() : rodasExistente.material(),
                request.corAcabamento() != null ? request.corAcabamento() : rodasExistente.corAcabamento(),
                request.precoCusto() != null ? request.precoCusto() : rodasExistente.precoCusto(),
                request.precoVenda() != null ? request.precoVenda() : rodasExistente.precoVenda(),
                request.estoque() != null ? request.estoque() : rodasExistente.estoque(),
                rodasExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Rodas toEntity(RodasRequest request){
        return new Rodas(
                null,
                request.marcaId(),
                request.codigo(),
                request.nome(),
                request.aro(),
                request.larguraPolegadas(),
                request.furos(),
                request.diametroFuracaoMm(),
                request.offsetEtMm(),
                request.material(),
                request.corAcabamento(),
                request.precoCusto(),
                request.precoVenda(),
                request.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
