package dev.matheus.infrastructure.mapper.produto;

import dev.matheus.core.entities.Produtos;
import dev.matheus.infrastructure.dto.produto.ProdutosCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProdutosCreateMapper {

    public ProdutosCreateRequest toDto(Produtos produtos){
        return new ProdutosCreateRequest(
                produtos.marcaId(),
                produtos.codigo(),
                produtos.nome(),
                produtos.descricao(),
                produtos.precoCusto(),
                produtos.precoVenda(),
                produtos.estoque()
        );
    }

    public Produtos toEntity(ProdutosCreateRequest create){
        return new Produtos(
                null,
                create.marcaId(),
                create.codigo(),
                create.nome(),
                create.descricao(),
                create.precoCusto(),
                create.precoVenda(),
                create.estoque(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}