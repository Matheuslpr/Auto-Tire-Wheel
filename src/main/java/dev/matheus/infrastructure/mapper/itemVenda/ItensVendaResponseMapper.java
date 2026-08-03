package dev.matheus.infrastructure.mapper.itemVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaResponse;
import org.springframework.stereotype.Component;

@Component
public class ItensVendaResponseMapper {

    public ItensVendaResponse toDto(ItensVenda itensVenda) {
        return new ItensVendaResponse(
                itensVenda.id(),
                itensVenda.vendaId(),
                itensVenda.tipoItem(),
                itensVenda.itemId(),
                itensVenda.quantidade(),
                itensVenda.precoUnitario(),
                itensVenda.subtotal()
        );
    }

    public static ItensVenda toEntity(ItensVendaResponse response) {
        return new ItensVenda(
                response.id(),
                response.vendaId(),
                response.tipoItem(),
                response.itemId(),
                response.quantidade(),
                response.precoUnitario(),
                response.subtotal()
        );
    }
}
