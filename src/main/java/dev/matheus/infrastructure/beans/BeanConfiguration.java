package dev.matheus.infrastructure.beans;

import dev.matheus.core.gateway.*;
import dev.matheus.core.usecases.clientes.*;
import dev.matheus.core.usecases.fornecedores.*;
import dev.matheus.core.usecases.funcionarios.*;
import dev.matheus.core.usecases.itensVenda.*;
import dev.matheus.core.usecases.marcas.*;
import dev.matheus.core.usecases.pneus.*;
import dev.matheus.core.usecases.produtos.*;
import dev.matheus.core.usecases.rodas.*;
import dev.matheus.core.usecases.vendas.*;
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

    // Beans for ItensVenda use case

    @Bean
    public AtualizarItensVendaUseCase atualizarItensVendaUseCase(ItensVendaGateway itensVendaGateway){
        return new AtualizarItensVendaUseCaseImpl(itensVendaGateway);
    }

    @Bean
    public CadastrarItensVendaUseCase cadastrarItensVendaUseCase(ItensVendaGateway itensVendaGateway){
        return new CadastrarItensVendaUseCaseImpl(itensVendaGateway);
    }

    @Bean
    public BuscarItensVendaUseCase buscarItensVendaUseCase(ItensVendaGateway itensVendaGateway){
        return new BuscarItensVendaUseCaseImpl(itensVendaGateway);
    }

    @Bean
    public ListarItensVendaUseCase itensVendaUseCase(ItensVendaGateway itensVendaGateway){
        return new ListarItensVendaUseCaseImpl(itensVendaGateway);
    }

    @Bean
    public DeletarItensVendaUseCase deletarItensVendaUseCase(ItensVendaGateway itensVendaGateway){
        return new DeletarItensVendaUseCaseImpl(itensVendaGateway);
    }

    // Beans for Marca use case

    @Bean
    public AtualizarMarcasUseCase atualizarMarcasUseCase(MarcasGateway marcasGateway){
        return new AtualizarMarcasUseCaseImpl(marcasGateway);
    }

    @Bean
    public CadastrarMarcasUseCase cadastrarMarcasUseCase(MarcasGateway marcasGateway){
        return new CadastrarMarcasUseCaseImpl(marcasGateway);
    }

    @Bean
    public BuscarMarcasUseCase buscarMarcasUseCase(MarcasGateway marcasGateway){
        return new BuscarMarcasUseCaseImpl(marcasGateway);
    }

    @Bean
    public ListarMarcasUseCase listarMarcasUseCase(MarcasGateway marcasGateway){
        return new ListarMarcasUseCaseImpl(marcasGateway);
    }

    @Bean
    public DeletarMarcasUseCase deletarMarcasUseCase(MarcasGateway marcasGateway){
        return new DeletarMarcasUseCaseImpl(marcasGateway);
    }

    // Beans for Pneus use case

    @Bean
    public CadastrarPneusUseCase cadastrarPneusUseCase(PneusGateway pneusGateway){
        return new CadastrarPneusUseCaseImpl(pneusGateway);
    }

    @Bean
    public BuscarPneusUseCase buscarPneusUseCase(PneusGateway pneusGateway){
        return new BuscarPneusUseCaseImpl(pneusGateway);
    }

    @Bean
    public AtualizarPneusUseCase atualizarPneusUseCase(PneusGateway pneusGateway){
        return new AtualizarPneusUseCaseImpl(pneusGateway);
    }

    @Bean
    public ListarPneusUseCase listarPneusUseCase(PneusGateway pneusGateway){
        return new ListarPneusUseCaseImpl(pneusGateway);
    }

    @Bean
    public DeletarPneusUseCase deletarPneusUseCase(PneusGateway pneusGateway){
        return new DeletarPneusUseCaseImpl(pneusGateway);
    }

    // Beans for Produtos use case

    @Bean
    public CadastrarProdutosUseCase cadastrarProdutosUseCase(ProdutosGateway produtosGateway){
        return new CadastrarProdutosUseCaseImpl(produtosGateway);
    }

    @Bean
    public BuscarProdutosUseCase buscarProdutosUseCase(ProdutosGateway produtosGateway){
        return new BuscarProdutosUseCaseImpl(produtosGateway);
    }

    @Bean
    public AtualizarProdutosUseCase atualizarProdutosUseCase(ProdutosGateway produtosGateway){
        return new AtualizarProdutosUseCaseImpl(produtosGateway);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCase(ProdutosGateway produtosGateway){
        return new ListarProdutosUseCaseImpl(produtosGateway);
    }

    @Bean
    public DeletarProdutosUseCase deletarProdutosUseCase(ProdutosGateway produtosGateway){
        return new DeletarProdutosUseCaseImpl(produtosGateway);
    }

    // Beans for Rodas use case

    @Bean
    public CadastrarRodasUseCase cadastrarRodasUseCase(RodasGateway rodasGateway){
        return new CadastrarRodasUseCaseImpl(rodasGateway);
    }

    @Bean
    public BuscarRodasUseCase buscarRodasUseCase(RodasGateway rodasGateway){
        return new BuscarRodasUseCaseImpl(rodasGateway);
    }

    @Bean
    public AtualizarRodasUseCase atualizarRodasUseCase(RodasGateway rodasGateway){
        return new AtualizarRodasUseCaseImpl(rodasGateway);
    }

    @Bean
    public ListarRodasUseCase listarRodasUseCase(RodasGateway rodasGateway){
        return new ListarRodasUseCaseImpl(rodasGateway);
    }

    @Bean
    public DeletarRodasUseCase deletarRodasUseCase(RodasGateway rodasGateway){
        return new DeletarRodasUseCaseImpl(rodasGateway);
    }

    // Beans for Vendas use case

    @Bean
    public CriarVendasUseCase criarVendasUseCase(VendasGateway vendasGateway){
        return new CriarVendasUseCaseImpl(vendasGateway);
    }

    @Bean
    public BuscarVendasUseCase buscarVendasUseCase(VendasGateway vendasGateway){
        return new BuscarVendasUseCaseImpl(vendasGateway);
    }

    @Bean
    public AtualizarVendasUseCase atualizarVendasUseCase(VendasGateway vendasGateway){
        return new AtualizarVendasUseCaseImpl(vendasGateway);
    }

    @Bean
    public ListarVendasUseCase listarVendasUseCase(VendasGateway vendasGateway){
        return new ListarVendasUseCaseImpl(vendasGateway);
    }

    @Bean
    public ConcluirVendasUseCase concluirVendasUseCase(VendasGateway vendasGateway){
        return new ConcluirVendasUseCaseImpl(vendasGateway);
    }

    @Bean
    public CancelarVendasUseCase cancelarVendasUseCase(VendasGateway vendasGateway){
        return new CancelarVendasUseCaseImpl(vendasGateway);
    }
}
