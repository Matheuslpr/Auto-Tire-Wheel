package dev.matheus.infrastructure.mapper.venda;

import dev.matheus.core.entities.Vendas;
import dev.matheus.infrastructure.dto.venda.VendasRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendasUpdateMapper {

    public VendasRequest toDto(Vendas vendas) {
        return new VendasRequest(
                vendas.clienteId(),
                vendas.funcionarioId(),
                vendas.dataVenda(),
                vendas.formaPagamento(),
                vendas.valorTotal()
        );
    }

    public Vendas merge(Vendas vendasExistente, VendasRequest request){
        return new Vendas(
                vendasExistente.id(),
                request.clienteId() != null ? request.clienteId() : vendasExistente.clienteId(),
                request.funcionarioId() != null ? request.funcionarioId() : vendasExistente.funcionarioId(),
                request.dataVenda() != null ? request.dataVenda() : vendasExistente.dataVenda(),
                request.formaPagamento() != null ? request.formaPagamento() : vendasExistente.formaPagamento(),
                request.valorTotal() != null ? request.valorTotal() : vendasExistente.valorTotal(),
                vendasExistente.status(),
                vendasExistente.dataCadastro(),
                LocalDateTime.now()
        );
    }

    public Vendas toEntity(VendasRequest request){
        return new Vendas(
                null,
                request.clienteId(),
                request.funcionarioId(),
                request.dataVenda(),
                request.formaPagamento(),
                request.valorTotal(),
                dev.matheus.core.enuns.StatusVenda.ABERTA,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
