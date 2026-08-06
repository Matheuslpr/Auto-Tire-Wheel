package dev.matheus.infrastructure.mapper.produto;

import dev.matheus.core.entities.Produtos;
import dev.matheus.infrastructure.persistence.ProdutosEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutosEntityMapper {

    public ProdutosEntity toEntity(Produtos produtos) {
        ProdutosEntity entity = new ProdutosEntity();

        entity.setId(produtos.id());
        entity.setMarcaId(produtos.marcaId());
        entity.setCodigo(produtos.codigo());
        entity.setNome(produtos.nome());
        entity.setDescricao(produtos.descricao());
        entity.setPrecoCusto(produtos.precoCusto());
        entity.setPrecoVenda(produtos.precoVenda());
        entity.setEstoque(produtos.estoque());
        entity.setDataCadastro(produtos.dataCadastro());
        entity.setDataAtualizacao(produtos.dataAtualizacao());

        return entity;
    }

    public Produtos toDomain(ProdutosEntity produtos) {
        return new Produtos(
                produtos.getId(),
                produtos.getMarcaId(),
                produtos.getCodigo(),
                produtos.getNome(),
                produtos.getDescricao(),
                produtos.getPrecoCusto(),
                produtos.getPrecoVenda(),
                produtos.getEstoque(),
                produtos.getDataCadastro(),
                produtos.getDataAtualizacao()
        );
    }

}
