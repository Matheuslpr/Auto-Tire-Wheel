package dev.matheus.infrastructure.mapper.venda;

import dev.matheus.core.entities.Vendas;
import dev.matheus.infrastructure.dto.venda.VendasResponse;
import org.springframework.stereotype.Component;

@Component
public class VendasResponseMapper {

    public VendasResponse toDto(Vendas vendas) {
        return new VendasResponse(
                vendas.id(),
                vendas.clienteId(),
                vendas.funcionarioId(),
                vendas.dataVenda(),
                vendas.formaPagamento(),
                vendas.valorTotal(),
                vendas.status(),
                vendas.dataCadastro(),
                vendas.dataAtualizacao()
        );
    }

    public static Vendas toEntity(VendasResponse response) {
        return new Vendas(
                response.id(),
                response.clienteId(),
                response.funcionarioId(),
                response.dataVenda(),
                response.formaPagamento(),
                response.valorTotal(),
                response.status(),
                response.dataCadastro(),
                response.dataAtualizacao()
        );
    }
}
