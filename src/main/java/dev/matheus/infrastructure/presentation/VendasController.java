package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Vendas;
import dev.matheus.core.usecases.vendas.*;
import dev.matheus.infrastructure.dto.venda.VendasCreateRequest;
import dev.matheus.infrastructure.dto.venda.VendasRequest;
import dev.matheus.infrastructure.dto.venda.VendasResponse;
import dev.matheus.infrastructure.mapper.venda.VendasCreateMapper;
import dev.matheus.infrastructure.mapper.venda.VendasResponseMapper;
import dev.matheus.infrastructure.mapper.venda.VendasUpdateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    private final CriarVendasUseCase criarVendasUseCase;
    private final BuscarVendasUseCase buscarVendasUseCase;
    private final AtualizarVendasUseCase atualizarVendasUseCase;
    private final ListarVendasUseCase listarVendasUseCase;
    private final ConcluirVendasUseCase concluirVendasUseCase;
    private final CancelarVendasUseCase cancelarVendasUseCase;
    private final VendasCreateMapper vendasCreateMapper;
    private final VendasResponseMapper vendasResponseMapper;
    private final VendasUpdateMapper vendasUpdateMapper;

    public VendasController(CriarVendasUseCase criarVendasUseCase, BuscarVendasUseCase buscarVendasUseCase, AtualizarVendasUseCase atualizarVendasUseCase, ListarVendasUseCase listarVendasUseCase, ConcluirVendasUseCase concluirVendasUseCase, CancelarVendasUseCase cancelarVendasUseCase, VendasCreateMapper vendasCreateMapper, VendasResponseMapper vendasResponseMapper, VendasUpdateMapper vendasUpdateMapper) {
        this.criarVendasUseCase = criarVendasUseCase;
        this.buscarVendasUseCase = buscarVendasUseCase;
        this.atualizarVendasUseCase = atualizarVendasUseCase;
        this.listarVendasUseCase = listarVendasUseCase;
        this.concluirVendasUseCase = concluirVendasUseCase;
        this.cancelarVendasUseCase = cancelarVendasUseCase;
        this.vendasCreateMapper = vendasCreateMapper;
        this.vendasResponseMapper = vendasResponseMapper;
        this.vendasUpdateMapper = vendasUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Vendas listadas com sucesso");
        response.put("Vendas", listarVendasUseCase.execute().stream().map(vendasResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendasResponse> findById(@PathVariable Long id){
        Vendas vendas = buscarVendasUseCase.execute(id);
        return ResponseEntity.ok(vendasResponseMapper.toDto(vendas));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody VendasCreateRequest request){
        Vendas create = criarVendasUseCase.execute(vendasCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Venda criada com sucesso");
        response.put("Venda", vendasResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@Valid @RequestBody VendasRequest request){
        Vendas existing = buscarVendasUseCase.execute(id);
        Vendas replace = atualizarVendasUseCase.execute(vendasUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Venda atualizada com sucesso");
        response.put("Venda", vendasResponseMapper.toDto(replace));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<Map<String, Object>> concluir(@PathVariable Long id){
        Vendas concluida = concluirVendasUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Venda concluída com sucesso");
        response.put("Venda", vendasResponseMapper.toDto(concluida));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Map<String, Object>> cancelar(@PathVariable Long id){
        Vendas cancelada = cancelarVendasUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Venda cancelada com sucesso");
        response.put("Venda", vendasResponseMapper.toDto(cancelada));
        return ResponseEntity.ok(response);
    }
}