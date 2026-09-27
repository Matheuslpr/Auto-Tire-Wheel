package dev.matheus.core.gateway;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.enuns.TipoItemVenda;

import java.util.List;

public interface ItensVendaGateway {

    ItensVenda create(ItensVenda itensVenda);
    ItensVenda findById(Long id);
    ItensVenda replace(ItensVenda itensVenda);
    List<ItensVenda> findAll();
    ItensVenda delete(Long id);
    boolean existsDuplicado(Long vendaId, TipoItemVenda tipoItem, Long itemId);
    List<ItensVenda> findByVendaId(Long vendaId);

}
