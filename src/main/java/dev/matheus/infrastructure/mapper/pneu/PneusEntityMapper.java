package dev.matheus.infrastructure.mapper.pneu;

import dev.matheus.core.entities.Pneus;
import dev.matheus.infrastructure.persistence.PneusEntity;
import org.springframework.stereotype.Component;

@Component
public class PneusEntityMapper {

    public PneusEntity toEntity(Pneus pneus) {
        PneusEntity entity = new PneusEntity();

        entity.setMarcaId(pneus.marcaId());
        entity.setCodigo(pneus.codigo());
        entity.setNome(pneus.nome());
        entity.setLarguraMm(pneus.larguraMm());
        entity.setPerfil(pneus.perfil());
        entity.setAro(pneus.aro());
        entity.setIndiceCarga(pneus.indiceCarga());
        entity.setIndiceVelocidade(pneus.indiceVelocidade());
        entity.setPrecoCusto(pneus.precoCusto());
        entity.setPrecoVenda(pneus.precoVenda());
        entity.setEstoque(pneus.estoque());
        entity.setDataCadastro(pneus.dataCadastro());
        entity.setDataAtualizacao(pneus.dataAtualizacao());

        return entity;
    }

    public static Pneus toDomain(PneusEntity pneus) {
        return new Pneus(
                pneus.getId(),
                pneus.getMarcaId(),
                pneus.getCodigo(),
                pneus.getNome(),
                pneus.getLarguraMm(),
                pneus.getPerfil(),
                pneus.getAro(),
                pneus.getIndiceCarga(),
                pneus.getIndiceVelocidade(),
                pneus.getPrecoCusto(),
                pneus.getPrecoVenda(),
                pneus.getEstoque(),
                pneus.getDataCadastro(),
                pneus.getDataAtualizacao()
        );
    }
}