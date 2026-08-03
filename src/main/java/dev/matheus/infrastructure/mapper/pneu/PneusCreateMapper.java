package dev.matheus.infrastructure.mapper.pneu;

import dev.matheus.core.entities.Pneus;
import dev.matheus.infrastructure.dto.pneu.PneusCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PneusCreateMapper {

    public PneusCreateRequest toDto(Pneus pneus){
        return new PneusCreateRequest(
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

    public Pneus toEntity(PneusCreateRequest create){
        return new Pneus(
                null,
                create.marcaId(),
                create.codigo(),
                create.nome(),
                create.larguraMm(),
                create.perfil(),
                create.aro(),
                create.indiceCarga(),
                create.indiceVelocidade(),
                create.precoCusto(),
                create.precoVenda(),
                create.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
