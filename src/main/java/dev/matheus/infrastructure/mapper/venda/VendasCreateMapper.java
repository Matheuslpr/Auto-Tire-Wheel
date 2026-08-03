package dev.matheus.infrastructure.mapper.venda;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.enuns.StatusVenda;
import dev.matheus.infrastructure.dto.venda.VendasCreateRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class VendasCreateMapper {

    public VendasCreateRequest toDto(Vendas vendas){
        return new VendasCreateRequest(
                vendas.clienteId(),
                vendas.funcionarioId(),
                vendas.dataVenda(),
                vendas.formaPagamento()
        );
    }

    public Vendas toEntity(VendasCreateRequest create){
        return new Vendas(
                null,
                create.clienteId(),
                create.funcionarioId(),
                create.dataVenda(),
                create.formaPagamento(),
                BigDecimal.ZERO,
                StatusVenda.ABERTA,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}