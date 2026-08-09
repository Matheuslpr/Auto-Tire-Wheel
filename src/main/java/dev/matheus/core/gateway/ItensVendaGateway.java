package dev.matheus.core.gateway;

import dev.matheus.core.entities.ItensVenda;

import java.util.List;

public interface ItensVendaGateway {

    ItensVenda create(ItensVenda itensVenda);
    ItensVenda findById(Long id);
    ItensVenda replace(ItensVenda itensVenda);
    List<ItensVenda> findAll();
    ItensVenda delete(Long id);
}
