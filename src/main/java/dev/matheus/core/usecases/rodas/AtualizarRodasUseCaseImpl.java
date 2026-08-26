package dev.matheus.core.usecases.rodas;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.gateway.RodasGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class AtualizarRodasUseCaseImpl implements AtualizarRodasUseCase {

    private final RodasGateway gateway;

    public AtualizarRodasUseCaseImpl(RodasGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Rodas execute(Rodas rodas) {
        var existente = gateway.findById(rodas.id());
        if (existente == null) {
            throw new ResourceNotFoundException("Roda não encontrada");
        }
        return gateway.replace(new Rodas(
                existente.id(),
                rodas.marcaId(),
                rodas.codigo(),
                rodas.nome(),
                rodas.aro(),
                rodas.larguraPolegadas(),
                rodas.furos(),
                rodas.diametroFuracaoMm(),
                rodas.offsetEtMm(),
                rodas.material(),
                rodas.corAcabamento(),
                rodas.precoCusto(),
                rodas.precoVenda(),
                rodas.estoque(),
                existente.dataCadastro(),
                rodas.dataAtualizacao()
        ));
    }
}