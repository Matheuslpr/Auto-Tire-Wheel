package dev.matheus.infrastructure.mapper.itemVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaRequest;
import org.springframework.stereotype.Component;

@Component
public class ItensVendaUpdateMapper {

    public ItensVendaRequest toDto(ItensVenda itensVenda) {
        return new ItensVendaRequest(
                itensVenda.vendaId(),
                itensVenda.tipoItem(),
                itensVenda.itemId(),
                itensVenda.quantidade(),
                itensVenda.precoUnitario(),
                itensVenda.subtotal()
        );
    }

    public ItensVenda merge(ItensVenda itensVendaExistente, ItensVendaRequest request){
        return new ItensVenda(
                itensVendaExistente.id(),
                request.vendaId() != null ? request.vendaId() : itensVendaExistente.vendaId(),
                request.tipoItem() != null ? request.tipoItem() : itensVendaExistente.tipoItem(),
                request.itemId() != null ? request.itemId() : itensVendaExistente.itemId(),
                request.quantidade() != null ? request.quantidade() : itensVendaExistente.quantidade(),
                request.precoUnitario() != null ? request.precoUnitario() : itensVendaExistente.precoUnitario(),
                request.subtotal() != null ? request.subtotal() : itensVendaExistente.subtotal()
        );
    }

    public ItensVenda toEntity(ItensVendaRequest request){
        return new ItensVenda(
                null,
                request.vendaId(),
                request.tipoItem(),
                request.itemId(),
                request.quantidade(),
                request.precoUnitario(),
                request.subtotal()
        );
    }
}
