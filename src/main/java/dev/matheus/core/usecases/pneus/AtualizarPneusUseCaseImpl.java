package dev.matheus.core.usecases.pneus;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.gateway.PneusGateway;
import dev.matheus.infrastructure.exception.ResourceNotFoundException;

public class AtualizarPneusUseCaseImpl implements AtualizarPneusUseCase {

    private final PneusGateway gateway;

    public AtualizarPneusUseCaseImpl(PneusGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pneus execute(Pneus pneus){
        var existente = gateway.findById(pneus.id());
        if (existente == null) {
            throw new ResourceNotFoundException("Pneu não encontrado");
        }
        return gateway.replace(new Pneus(
                existente.id(),
                pneus.marcaId(),
                pneus.codigo(),
                pneus.nome(),
                pneus.larguraMm(),
                pneus.perfil(),
                pneus.aro(),
                pneus.indiceCarga(),
                pneus.indiceVelocidade(),
                pneus.precoCusto(),
                pneus.precoVenda(),
                pneus.estoque(),
                existente.dataCadastro(),
                pneus.dataAtualizacao()
        ));
    }

}
