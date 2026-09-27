package dev.matheus.infrastructure.persistence;

import dev.matheus.core.enuns.TipoItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensVendasRepository extends JpaRepository<ItensVendaEntity, Long> {
    List<ItensVendaEntity> findByVendaId(Long vendaId);

    boolean existsByVendaIdAndTipoItemAndItemId(Long vendaId, TipoItemVenda tipoItem, Long itemId);

}
