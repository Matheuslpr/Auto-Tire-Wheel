package dev.matheus.infrastructure.mapper.itemVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class ItensVendaCreateMapper {

    public ItensVendaCreateRequest toDto(ItensVenda itensVenda){
        return new ItensVendaCreateRequest(
                itensVenda.vendaId(),
                itensVenda.tipoItem(),
                itensVenda.itemId(),
                itensVenda.quantidade(),
                itensVenda.precoUnitario(),
                itensVenda.subtotal()
        );
    }

    public ItensVenda toEntity(ItensVendaCreateRequest create){
        return new ItensVenda(
                null,
                create.vendaId(),
                create.tipoItem(),
                create.itemId(),
                create.quantidade(),
                create.precoUnitario(),
                create.subtotal()
        );
    }
}
