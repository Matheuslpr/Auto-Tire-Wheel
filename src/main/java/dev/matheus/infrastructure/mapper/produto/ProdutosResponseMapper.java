package dev.matheus.infrastructure.mapper.produto;

import dev.matheus.core.entities.Produtos;
import dev.matheus.infrastructure.dto.produto.ProdutosResponse;
import org.springframework.stereotype.Component;

@Component
public class ProdutosResponseMapper {

    public ProdutosResponse toDto(Produtos produtos) {
        return new ProdutosResponse(
                produtos.id(),
                produtos.marcaId(),
                produtos.codigo(),
                produtos.nome(),
                produtos.descricao(),
                produtos.precoCusto(),
                produtos.precoVenda(),
                produtos.estoque(),
                produtos.dataCadastro(),
                produtos.dataAtualizacao()
        );
    }

    public static Produtos toEntity(ProdutosResponse response) {
        return new Produtos(
                response.id(),
                response.marcaId(),
                response.codigo(),
                response.nome(),
                response.descricao(),
                response.precoCusto(),
                response.precoVenda(),
                response.estoque(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}
