package dev.matheus.infrastructure.mapper.roda;

import dev.matheus.core.entities.Rodas;
import dev.matheus.infrastructure.dto.roda.RodasResponse;
import org.springframework.stereotype.Component;

@Component
public class RodasResponseMapper {

    public RodasResponse toDto(Rodas rodas) {
        return new RodasResponse(
                rodas.id(),
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
                rodas.estoque(),
                rodas.dataCadastro(),
                rodas.dataAtualizacao()
        );
    }

    public static Rodas toEntity(RodasResponse response) {
        return new Rodas(
                response.id(),
                response.marcaId(),
                response.codigo(),
                response.nome(),
                response.aro(),
                response.larguraPolegadas(),
                response.furos(),
                response.diametroFuracaoMm(),
                response.offsetEtMm(),
                response.material(),
                response.corAcabamento(),
                response.precoCusto(),
                response.precoVenda(),
                response.estoque(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}
