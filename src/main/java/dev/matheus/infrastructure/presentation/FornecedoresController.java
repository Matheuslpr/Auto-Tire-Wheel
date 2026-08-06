package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Fornecedores;
import dev.matheus.core.usecases.fornecedores.*;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresCreateRequest;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresRequest;
import dev.matheus.infrastructure.dto.fornecedor.FornecedoresResponse;
import dev.matheus.infrastructure.mapper.fornecedor.FornecedoresCreateMapper;
import dev.matheus.infrastructure.mapper.fornecedor.FornecedoresResponseMapper;
import dev.matheus.infrastructure.mapper.fornecedor.FornecedoresUpdateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    private final CadastrarFornecedoresUseCase cadastrarFornecedoresUseCase;
    private final BuscarFornecedoresUseCase buscarFornecedoresUseCase;
    private final AtualizarFornecedoresUseCase atualizarFornecedoresUseCase;
    private final ListarFornecedoresUseCase listarFornecedoresUseCase;
    private final DeletarFornecedoresUseCase deletarFornecedoresUseCase;
    private final FornecedoresCreateMapper fornecedoresCreateMapper;
    private final FornecedoresResponseMapper fornecedoresResponseMapper;
    private final FornecedoresUpdateMapper fornecedoresUpdateMapper;

    public FornecedoresController(CadastrarFornecedoresUseCase cadastrarFornecedoresUseCase, BuscarFornecedoresUseCase buscarFornecedoresUseCase, AtualizarFornecedoresUseCase atualizarFornecedoresUseCase, ListarFornecedoresUseCase listarFornecedoresUseCase, DeletarFornecedoresUseCase deletarFornecedoresUseCase, FornecedoresCreateMapper fornecedoresCreateMapper, FornecedoresResponseMapper fornecedoresResponseMapper, FornecedoresUpdateMapper fornecedoresUpdateMapper) {
        this.cadastrarFornecedoresUseCase = cadastrarFornecedoresUseCase;
        this.buscarFornecedoresUseCase = buscarFornecedoresUseCase;
        this.atualizarFornecedoresUseCase = atualizarFornecedoresUseCase;
        this.listarFornecedoresUseCase = listarFornecedoresUseCase;
        this.deletarFornecedoresUseCase = deletarFornecedoresUseCase;
        this.fornecedoresCreateMapper = fornecedoresCreateMapper;
        this.fornecedoresResponseMapper = fornecedoresResponseMapper;
        this.fornecedoresUpdateMapper = fornecedoresUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Fornecedores listados com sucesso");
        response.put("Fornecedores" , listarFornecedoresUseCase.execute().stream().map(fornecedoresResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedoresResponse> findById(@PathVariable Long id){
        Fornecedores fornecedores = buscarFornecedoresUseCase.execute(id);
        if(fornecedores == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedoresResponseMapper.toDto(fornecedores));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody FornecedoresCreateRequest request){
        Fornecedores create = cadastrarFornecedoresUseCase.execute(fornecedoresCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Fornecedores criado com sucesso");
        response.put("Fornecedores" , fornecedoresResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id, @RequestBody FornecedoresRequest request){
        Fornecedores existing = buscarFornecedoresUseCase.execute(id);
        if(existing == null){
            return ResponseEntity.notFound().build();
        }
        Fornecedores replace = atualizarFornecedoresUseCase.execute(fornecedoresUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Fornecedores criado com sucesso");
        response.put("Fornecedores" , fornecedoresResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        Fornecedores existing = buscarFornecedoresUseCase.execute(id);
        if(existing == null) {
            return ResponseEntity.notFound().build();
        }
        Fornecedores deleted = deletarFornecedoresUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Fornecedor deletado com sucesso");
        response.put("Fornecedor" , fornecedoresResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);}

}
