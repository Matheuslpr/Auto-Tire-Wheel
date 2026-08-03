package dev.matheus.infrastructure.mapper.venda;

import dev.matheus.core.entities.Vendas;
import dev.matheus.infrastructure.persistence.VendasEntity;
import org.springframework.stereotype.Component;

@Component
public class VendasEntityMapper {

    public VendasEntity toEntity(Vendas vendas) {
        VendasEntity entity = new VendasEntity();

        entity.setClienteId(vendas.clienteId());
        entity.setFuncionarioId(vendas.funcionarioId());
        entity.setDataVenda(vendas.dataVenda());
        entity.setFormaPagamento(vendas.formaPagamento());
        entity.setValorTotal(vendas.valorTotal());
        entity.setStatus(vendas.status());
        entity.setDataCadastro(vendas.dataCadastro());
        entity.setDataAtualizacao(vendas.dataAtualizacao());

        return entity;
    }

    public static Vendas toDomain(VendasEntity vendas) {
        return new Vendas(
                vendas.getId(),
                vendas.getClienteId(),
                vendas.getFuncionarioId(),
                vendas.getDataVenda(),
                vendas.getFormaPagamento(),
                vendas.getValorTotal(),
                vendas.getStatus(),
                vendas.getDataCadastro(),
                vendas.getDataAtualizacao()
        );
    }
}
