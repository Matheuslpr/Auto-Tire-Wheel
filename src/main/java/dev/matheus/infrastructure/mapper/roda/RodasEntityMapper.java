package dev.matheus.infrastructure.mapper.roda;

import dev.matheus.core.entities.Rodas;
import dev.matheus.infrastructure.persistence.RodasEntity;
import org.springframework.stereotype.Component;

@Component
public class RodasEntityMapper {

    public RodasEntity toEntity(Rodas rodas) {
        RodasEntity entity = new RodasEntity();

        entity.setMarcaId(rodas.marcaId());
        entity.setCodigo(rodas.codigo());
        entity.setNome(rodas.nome());
        entity.setAro(rodas.aro());
        entity.setLarguraPolegadas(rodas.larguraPolegadas());
        entity.setFuros(rodas.furos());
        entity.setDiametroFuracaoMm(rodas.diametroFuracaoMm());
        entity.setOffsetEtMm(rodas.offsetEtMm());
        entity.setMaterial(rodas.material());
        entity.setCorAcabamento(rodas.corAcabamento());
        entity.setPrecoCusto(rodas.precoCusto());
        entity.setPrecoVenda(rodas.precoVenda());
        entity.setEstoque(rodas.estoque());
        entity.setDataCadastro(rodas.dataCadastro());
        entity.setDataAtualizacao(rodas.dataAtualizacao());

        return entity;
    }

    public static Rodas toDomain(RodasEntity rodas) {
        return new Rodas(
                rodas.getId(),
                rodas.getMarcaId(),
                rodas.getCodigo(),
                rodas.getNome(),
                rodas.getAro(),
                rodas.getLarguraPolegadas(),
                rodas.getFuros(),
                rodas.getDiametroFuracaoMm(),
                rodas.getOffsetEtMm(),
                rodas.getMaterial(),
                rodas.getCorAcabamento(),
                rodas.getPrecoCusto(),
                rodas.getPrecoVenda(),
                rodas.getEstoque(),
                rodas.getDataCadastro(),
                rodas.getDataAtualizacao()
        );
    }
}
