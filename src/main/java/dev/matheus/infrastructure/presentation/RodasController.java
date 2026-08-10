package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Rodas;
import dev.matheus.core.usecases.rodas.*;
import dev.matheus.infrastructure.dto.roda.RodasCreateRequest;
import dev.matheus.infrastructure.dto.roda.RodasRequest;
import dev.matheus.infrastructure.dto.roda.RodasResponse;
import dev.matheus.infrastructure.mapper.roda.RodasCreateMapper;
import dev.matheus.infrastructure.mapper.roda.RodasResponseMapper;
import dev.matheus.infrastructure.mapper.roda.RodasUpdateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rodas")
public class RodasController {

    private final CadastrarRodasUseCase cadastrarRodasUseCase;
    private final BuscarRodasUseCase buscarRodasUseCase;
    private final AtualizarRodasUseCase atualizarRodasUseCase;
    private final ListarRodasUseCase listarRodasUseCase;
    private final DeletarRodasUseCase deletarRodasUseCase;
    private final RodasCreateMapper rodasCreateMapper;
    private final RodasResponseMapper rodasResponseMapper;
    private final RodasUpdateMapper rodasUpdateMapper;

    public RodasController(CadastrarRodasUseCase cadastrarRodasUseCase, BuscarRodasUseCase buscarRodasUseCase, AtualizarRodasUseCase atualizarRodasUseCase, ListarRodasUseCase listarRodasUseCase, DeletarRodasUseCase deletarRodasUseCase, RodasCreateMapper rodasCreateMapper, RodasResponseMapper rodasResponseMapper, RodasUpdateMapper rodasUpdateMapper) {
        this.cadastrarRodasUseCase = cadastrarRodasUseCase;
        this.buscarRodasUseCase = buscarRodasUseCase;
        this.atualizarRodasUseCase = atualizarRodasUseCase;
        this.listarRodasUseCase = listarRodasUseCase;
        this.deletarRodasUseCase = deletarRodasUseCase;
        this.rodasCreateMapper = rodasCreateMapper;
        this.rodasResponseMapper = rodasResponseMapper;
        this.rodasUpdateMapper = rodasUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Rodas listadas com sucesso");
        response.put("Rodas", listarRodasUseCase.execute().stream().map(rodasResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RodasResponse> findById(@PathVariable Long id){
        Rodas rodas = buscarRodasUseCase.execute(id);
        return ResponseEntity.ok(rodasResponseMapper.toDto(rodas));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody RodasCreateRequest request){
        Rodas create = cadastrarRodasUseCase.execute(rodasCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Roda cadastrada com sucesso");
        response.put("Roda", rodasResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@RequestBody RodasRequest request){
        Rodas existing = buscarRodasUseCase.execute(id);
        Rodas replace = atualizarRodasUseCase.execute(rodasUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Roda atualizada com sucesso");
        response.put("Roda", rodasResponseMapper.toDto(replace));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        buscarRodasUseCase.execute(id);
        Rodas deleted = deletarRodasUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Roda deletada com sucesso");
        response.put("Roda", rodasResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }
}