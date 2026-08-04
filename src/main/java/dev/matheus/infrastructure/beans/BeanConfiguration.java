package dev.matheus.infrastructure.beans;

import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.core.usecases.clientes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CadastrarClientesUseCase cadastrarClientesUseCase(ClientesGateway clientesGateway){
        return new CadastrarClientesUseCaseImpl(clientesGateway);
    }

    @Bean
    public AtualizarClientesUseCase atualizarClientesUseCase(ClientesGateway clientesGateway){
        return new AtualizarClientesUseCaseImpl(clientesGateway);
    }

    @Bean
    public BuscarClientesUseCase buscarClientesUseCase(ClientesGateway clientesGateway){
        return new BuscarClientesUseCaseImpl(clientesGateway);
    }

    @Bean
    public ListarClientesUseCase listarClientesUseCase(ClientesGateway clientesGateway){
        return new ListarClientesUseCaseImpl(clientesGateway);
    }

}
