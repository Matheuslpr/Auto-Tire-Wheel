package dev.matheus.infrastructure.beans;

import dev.matheus.core.gateway.ClientesGateway;
import dev.matheus.core.gateway.FornecedoresGateway;
import dev.matheus.core.gateway.FuncionariosGateway;
import dev.matheus.core.usecases.clientes.*;
import dev.matheus.core.usecases.fornecedores.*;
import dev.matheus.core.usecases.funcionarios.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Beans for Clientes use cases
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

    // Beans for Fornecedores use cases

    @Bean
    public CadastrarFornecedoresUseCase cadastrarFornecedoresUseCase(FornecedoresGateway fornecedoresGateway){
        return new CadastrarFornecedoresUseCaseImpl(fornecedoresGateway);
    }

    @Bean
    public AtualizarFornecedoresUseCase atualizarFornecedoresUseCase(FornecedoresGateway fornecedoresGateway){
        return new AtualizarFornecedoresUseCaseImpl(fornecedoresGateway);
    }

    @Bean
    public BuscarFornecedoresUseCase buscarFornecedoresUseCase(FornecedoresGateway fornecedoresGateway){
        return new BuscarFornecedoresUseCaseImpl(fornecedoresGateway);
    }

    @Bean
    public ListarFornecedoresUseCase listarFornecedoresUseCase(FornecedoresGateway fornecedoresGateway) {
        return new ListarFornecedoresUseCaseImpl(fornecedoresGateway);
    }

    @Bean
    public DeletarFornecedoresUseCase deletarFornecedoresUseCase(FornecedoresGateway fornecedoresGateway) {
        return new DeletarFornecedoresUseCaseImpl(fornecedoresGateway);
    }

    // Beans for Funcionarios use cases

    @Bean
    public AtualizarFuncionariosUseCase atualizarFuncionariosUseCase(FuncionariosGateway funcionariosGateway) {
        return new AtualizarFuncionariosUseCaseImpl(funcionariosGateway);
    }

    @Bean
    public CadastrarFuncionariosUseCase cadastrarFuncionariosUseCase(FuncionariosGateway funcionariosGateway) {
        return new CadastrarFuncionariosUseCaseImpl(funcionariosGateway);
    }

    @Bean
    public BuscarFuncionariosUseCase buscarFuncionariosUseCase(FuncionariosGateway funcionariosGateway) {
        return new BuscarFuncionariosUseCaseImpl(funcionariosGateway);
    }

    @Bean
    public ListarFuncionariosUseCase listarFuncionariosUseCase(FuncionariosGateway funcionariosGateway) {
        return new ListarFuncionariosUseCaseImpl(funcionariosGateway);
    }

    @Bean
    public DeletarFuncionariosUseCase deletarFuncionariosUseCase(FuncionariosGateway funcionariosGateway) {
        return new DeletarFuncionariosUseCaseImpl(funcionariosGateway);
    }
}
