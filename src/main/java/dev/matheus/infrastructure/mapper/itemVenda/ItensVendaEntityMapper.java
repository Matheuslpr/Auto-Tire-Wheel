package dev.matheus.infrastructure.mapper.itemVenda;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.infrastructure.persistence.ItensVendaEntity;
import org.springframework.stereotype.Component;

@Component
public class ItensVendaEntityMapper {

    public ItensVendaEntity toEntity(ItensVenda itensVenda) {
        ItensVendaEntity entity = new ItensVendaEntity();

        entity.setId(itensVenda.id());
        entity.setVendaId(itensVenda.vendaId());
        entity.setTipoItem(itensVenda.tipoItem());
        entity.setItemId(itensVenda.itemId());
        entity.setQuantidade(itensVenda.quantidade());
        entity.setPrecoUnitario(itensVenda.precoUnitario());
        entity.setSubtotal(itensVenda.subtotal());

        return entity;
    }

    public ItensVenda toDomain(ItensVendaEntity itensVenda) {
        return new ItensVenda(
                itensVenda.getId(),
                itensVenda.getVendaId(),
                itensVenda.getTipoItem(),
                itensVenda.getItemId(),
                itensVenda.getQuantidade(),
                itensVenda.getPrecoUnitario(),
                itensVenda.getSubtotal()
        );
    }
}
