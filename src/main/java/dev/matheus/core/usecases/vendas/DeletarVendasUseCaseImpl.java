package dev.matheus.core.usecases.vendas;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.gateway.ItensVendaGateway;
import dev.matheus.core.gateway.VendasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class DeletarVendasUseCaseImpl implements DeletarVendasUseCase {

    private final VendasGateway gateway;
    private final ItensVendaGateway itensVendaGateway;

    public DeletarVendasUseCaseImpl(VendasGateway gateway, ItensVendaGateway itensVendaGateway) {
        this.gateway = gateway;
        this.itensVendaGateway = itensVendaGateway;
    }

    @Override
    @Transactional
    public Vendas execute(Long id) {
        Vendas existente = gateway.findById(id);
        if (existente == null) {
            throw new ResourceNotFoundException("Venda não encontrada");
        }
        if (!itensVendaGateway.findByVendaId(id).isEmpty()) {
            throw new IllegalStateException("Não é possível excluir uma venda que possui itens. Remova os itens primeiro");
        }
        return gateway.delete(id);
    }
}
