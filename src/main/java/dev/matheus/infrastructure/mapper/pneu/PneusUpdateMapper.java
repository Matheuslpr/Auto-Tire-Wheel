package dev.matheus.infrastructure.mapper.pneu;

import dev.matheus.core.entities.Pneus;
import dev.matheus.infrastructure.dto.pneu.PneusRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PneusUpdateMapper {

    public PneusRequest toDto(Pneus pneus) {
        return new PneusRequest(
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
                pneus.estoque()
        );
    }

    public Pneus merge(Pneus pneusExistente, PneusRequest request){
        return new Pneus(
                pneusExistente.id(),
                request.marcaId() != null ? request.marcaId() : pneusExistente.marcaId(),
                request.codigo() != null ? request.codigo() : pneusExistente.codigo(),
                request.nome() != null ? request.nome() : pneusExistente.nome(),
                request.larguraMm() != null ? request.larguraMm() : pneusExistente.larguraMm(),
                request.perfil() != null ? request.perfil() : pneusExistente.perfil(),
                request.aro() != null ? request.aro() : pneusExistente.aro(),
                request.indiceCarga() != null ? request.indiceCarga() : pneusExistente.indiceCarga(),
                request.indiceVelocidade() != null ? request.indiceVelocidade() : pneusExistente.indiceVelocidade(),
                request.precoCusto() != null ? request.precoCusto() : pneusExistente.precoCusto(),
                request.precoVenda() != null ? request.precoVenda() : pneusExistente.precoVenda(),
                request.estoque() != null ? request.estoque() : pneusExistente.estoque(),
                pneusExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Pneus toEntity(PneusRequest request) {
        return new Pneus(
                null,
                request.marcaId(),
                request.codigo(),
                request.nome(),
                request.larguraMm(),
                request.perfil(),
                request.aro(),
                request.indiceCarga(),
                request.indiceVelocidade(),
                request.precoCusto(),
                request.precoVenda(),
                request.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

    }
}