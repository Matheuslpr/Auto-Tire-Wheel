package dev.matheus.infrastructure.mapper.produto;

import dev.matheus.core.entities.Produtos;
import dev.matheus.infrastructure.dto.produto.ProdutosRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProdutosUpdateMapper {

    public ProdutosRequest toDto(Produtos produtos) {
        return new ProdutosRequest(
                produtos.marcaId(),
                produtos.codigo(),
                produtos.nome(),
                produtos.descricao(),
                produtos.precoCusto(),
                produtos.precoVenda(),
                produtos.estoque()
        );
    }

    public Produtos merge(Produtos produtosExistente, ProdutosRequest request) {
        return new Produtos(
                produtosExistente.id(),
                request.marcaId() != null ? request.marcaId() : produtosExistente.marcaId(),
                request.codigo() != null ? request.codigo() : produtosExistente.codigo(),
                request.nome() != null ? request.nome() : produtosExistente.nome(),
                request.descricao() != null ? request.descricao() : produtosExistente.descricao(),
                request.precoCusto() != null ? request.precoCusto() : produtosExistente.precoCusto(),
                request.precoVenda() != null ? request.precoVenda() : produtosExistente.precoVenda(),
                request.estoque() != null ? request.estoque() : produtosExistente.estoque(),
                produtosExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Produtos toEntity(ProdutosRequest request) {
        return new Produtos(
                null,
                request.marcaId(),
                request.codigo(),
                request.nome(),
                request.descricao(),
                request.precoCusto(),
                request.precoVenda(),
                request.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
