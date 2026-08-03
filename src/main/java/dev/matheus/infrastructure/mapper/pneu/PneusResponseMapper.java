package dev.matheus.infrastructure.mapper.pneu;

import dev.matheus.core.entities.Pneus;
import dev.matheus.infrastructure.dto.pneu.PneusResponse;
import org.springframework.stereotype.Component;

@Component
public class PneusResponseMapper {

    public PneusResponse toDto(Pneus pneus) {
        return new PneusResponse(
                pneus.id(),
                pneus.marcaId(),
                pneus.codigo(),
                pneus.nome(),
                pneus.larguraMm(),
                pneus.perfil(),
                pneus.aro(),
                pneus.indiceCarga(),
                pneus.indiceVelocidade(),
                pneus.precoCusto(),
                pneus.precoVenda(),
                pneus.estoque(),
                pneus.dataCadastro(),
                pneus.dataAtualizacao()
        );
    }

    public static Pneus toEntity(PneusResponse response) {
        return new Pneus(
                response.id(),
                response.marcaId(),
                response.codigo(),
                response.nome(),
                response.larguraMm(),
                response.perfil(),
                response.aro(),
                response.indiceCarga(),
                response.indiceVelocidade(),
                response.precoCusto(),
                response.precoVenda(),
                response.estoque(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}