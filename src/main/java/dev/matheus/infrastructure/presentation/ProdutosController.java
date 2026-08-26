package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Produtos;
import dev.matheus.core.usecases.produtos.*;
import dev.matheus.infrastructure.dto.produto.ProdutosCreateRequest;
import dev.matheus.infrastructure.dto.produto.ProdutosRequest;
import dev.matheus.infrastructure.dto.produto.ProdutosResponse;
import dev.matheus.infrastructure.mapper.produto.ProdutosCreateMapper;
import dev.matheus.infrastructure.mapper.produto.ProdutosResponseMapper;
import dev.matheus.infrastructure.mapper.produto.ProdutosUpdateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final CadastrarProdutosUseCase cadastrarProdutosUseCase;
    private final BuscarProdutosUseCase buscarProdutosUseCase;
    private final AtualizarProdutosUseCase atualizarProdutosUseCase;
    private final ListarProdutosUseCase listarProdutosUseCase;
    private final DeletarProdutosUseCase deletarProdutosUseCase;
    private final ProdutosCreateMapper produtosCreateMapper;
    private final ProdutosResponseMapper produtosResponseMapper;
    private final ProdutosUpdateMapper produtosUpdateMapper;

    public ProdutosController(CadastrarProdutosUseCase cadastrarProdutosUseCase, BuscarProdutosUseCase buscarProdutosUseCase, AtualizarProdutosUseCase atualizarProdutosUseCase, ListarProdutosUseCase listarProdutosUseCase, DeletarProdutosUseCase deletarProdutosUseCase, ProdutosCreateMapper produtosCreateMapper, ProdutosResponseMapper produtosResponseMapper, ProdutosUpdateMapper produtosUpdateMapper) {
        this.cadastrarProdutosUseCase = cadastrarProdutosUseCase;
        this.buscarProdutosUseCase = buscarProdutosUseCase;
        this.atualizarProdutosUseCase = atualizarProdutosUseCase;
        this.listarProdutosUseCase = listarProdutosUseCase;
        this.deletarProdutosUseCase = deletarProdutosUseCase;
        this.produtosCreateMapper = produtosCreateMapper;
        this.produtosResponseMapper = produtosResponseMapper;
        this.produtosUpdateMapper = produtosUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Produtos listados com sucesso");
        response.put("Produtos", listarProdutosUseCase.execute().stream().map(produtosResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosResponse> findById(@PathVariable Long id){
        Produtos produtos = buscarProdutosUseCase.execute(id);
        return ResponseEntity.ok(produtosResponseMapper.toDto(produtos));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ProdutosCreateRequest request){
        Produtos create = cadastrarProdutosUseCase.execute(produtosCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Produto cadastrado com sucesso");
        response.put("Produto", produtosResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@Valid @RequestBody ProdutosRequest request){
        Produtos existing = buscarProdutosUseCase.execute(id);
        Produtos replace = atualizarProdutosUseCase.execute(produtosUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Produto atualizado com sucesso");
        response.put("Produto", produtosResponseMapper.toDto(replace));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        buscarProdutosUseCase.execute(id);
        Produtos deleted = deletarProdutosUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Produto deletado com sucesso");
        response.put("Produto", produtosResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }
}