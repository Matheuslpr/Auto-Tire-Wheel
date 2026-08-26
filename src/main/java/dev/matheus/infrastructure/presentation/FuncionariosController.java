package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Funcionarios;
import dev.matheus.core.usecases.funcionarios.*;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosCreateRequest;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosRequest;
import dev.matheus.infrastructure.dto.funcionario.FuncionariosResponse;
import dev.matheus.infrastructure.mapper.funcionario.FuncionariosCreateMapper;
import dev.matheus.infrastructure.mapper.funcionario.FuncionariosResponseMapper;
import dev.matheus.infrastructure.mapper.funcionario.FuncionariosUpdateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private final CadastrarFuncionariosUseCase cadastrarFuncionariosUseCase;
    private final BuscarFuncionariosUseCase buscarFuncionariosUseCase;
    private final AtualizarFuncionariosUseCase atualizarFuncionariosUseCase;
    private final ListarFuncionariosUseCase listarFuncionariosUseCase;
    private final DeletarFuncionariosUseCase deletarFuncionariosUseCase;
    private final FuncionariosCreateMapper funcionariosCreateMapper;
    private final FuncionariosResponseMapper funcionariosResponseMapper;
    private final FuncionariosUpdateMapper funcionariosUpdateMapper;

    public FuncionariosController(CadastrarFuncionariosUseCase cadastrarFuncionariosUseCase, BuscarFuncionariosUseCase buscarFuncionariosUseCase, AtualizarFuncionariosUseCase atualizarFuncionariosUseCase, ListarFuncionariosUseCase listarFuncionariosUseCase, DeletarFuncionariosUseCase deletarFuncionariosUseCase, FuncionariosCreateMapper funcionariosCreateMapper, FuncionariosResponseMapper funcionariosResponseMapper, FuncionariosUpdateMapper funcionariosUpdateMapper) {
        this.cadastrarFuncionariosUseCase = cadastrarFuncionariosUseCase;
        this.buscarFuncionariosUseCase = buscarFuncionariosUseCase;
        this.atualizarFuncionariosUseCase = atualizarFuncionariosUseCase;
        this.listarFuncionariosUseCase = listarFuncionariosUseCase;
        this.deletarFuncionariosUseCase = deletarFuncionariosUseCase;
        this.funcionariosCreateMapper = funcionariosCreateMapper;
        this.funcionariosResponseMapper = funcionariosResponseMapper;
        this.funcionariosUpdateMapper = funcionariosUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "funcionarios listados com sucesso");
        response.put("funcionarios" , listarFuncionariosUseCase.execute().stream().map(funcionariosResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosResponse> findById(@PathVariable Long id){
        Funcionarios funcionarios = buscarFuncionariosUseCase.execute(id);
        return ResponseEntity.ok(funcionariosResponseMapper.toDto(funcionarios));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody FuncionariosCreateRequest request){
        Funcionarios create = cadastrarFuncionariosUseCase.execute(funcionariosCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "funcionario cadastrado com sucesso");
        response.put("funcionario" , funcionariosResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@Valid @RequestBody FuncionariosRequest request){
        Funcionarios existing = buscarFuncionariosUseCase.execute(id);
        Funcionarios replace = atualizarFuncionariosUseCase.execute(funcionariosUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "funcionario atualizado com sucesso");
        response.put("funcionario" , funcionariosResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        buscarFuncionariosUseCase.execute(id);
        Funcionarios deleted = deletarFuncionariosUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "funcionario deletado com sucesso");
        response.put("funcionario" , funcionariosResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }
}
