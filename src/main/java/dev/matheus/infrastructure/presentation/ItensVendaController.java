package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.ItensVenda;
import dev.matheus.core.usecases.itensVenda.*;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaCreateRequest;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaRequest;
import dev.matheus.infrastructure.dto.itemVenda.ItensVendaResponse;
import dev.matheus.infrastructure.mapper.itemVenda.ItensVendaCreateMapper;
import dev.matheus.infrastructure.mapper.itemVenda.ItensVendaResponseMapper;
import dev.matheus.infrastructure.mapper.itemVenda.ItensVendaUpdateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/itens_venda")
public class ItensVendaController {

    private final CadastrarItensVendaUseCase cadastrarItensVendaUseCase;
    private final BuscarItensVendaUseCase buscarItensVendaUseCase;
    private final ListarItensVendaUseCase listarItensVendaUseCase;
    private final AtualizarItensVendaUseCase atualizarItensVendaUseCase;
    private final DeletarItensVendaUseCase deletarItensVendaUseCase;
    private final ItensVendaCreateMapper itensVendaCreateMapper;
    private final ItensVendaResponseMapper itensVendaResponseMapper;
    private final ItensVendaUpdateMapper itensVendaUpdateMapper;

    public ItensVendaController(CadastrarItensVendaUseCase cadastrarItensVendaUseCase, BuscarItensVendaUseCase buscarItensVendaUseCase, ListarItensVendaUseCase listarItensVendaUseCase, AtualizarItensVendaUseCase atualizarItensVendaUseCase, DeletarItensVendaUseCase deletarItensVendaUseCase, ItensVendaCreateMapper itensVendaCreateMapper, ItensVendaResponseMapper itensVendaResponseMapper, ItensVendaUpdateMapper itensVendaUpdateMapper) {
        this.cadastrarItensVendaUseCase = cadastrarItensVendaUseCase;
        this.buscarItensVendaUseCase = buscarItensVendaUseCase;
        this.listarItensVendaUseCase = listarItensVendaUseCase;
        this.atualizarItensVendaUseCase = atualizarItensVendaUseCase;
        this.deletarItensVendaUseCase = deletarItensVendaUseCase;
        this.itensVendaCreateMapper = itensVendaCreateMapper;
        this.itensVendaResponseMapper = itensVendaResponseMapper;
        this.itensVendaUpdateMapper = itensVendaUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Itens listados com sucesso");
        response.put("Itens" , listarItensVendaUseCase.execute().stream().map(itensVendaResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensVendaResponse> findById(@PathVariable Long id){
        ItensVenda itens = buscarItensVendaUseCase.execute(id);
        return ResponseEntity.ok(itensVendaResponseMapper.toDto(itens));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ItensVendaCreateRequest request){
        ItensVenda create = cadastrarItensVendaUseCase.execute(itensVendaCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Item cadastrado com sucesso");
        response.put("Item" , itensVendaResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id, @Valid @RequestBody ItensVendaRequest request){
        ItensVenda existing = buscarItensVendaUseCase.execute(id);
        ItensVenda replace = atualizarItensVendaUseCase.execute(itensVendaUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "item atualizado com sucesso");
        response.put("item" , itensVendaResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        buscarItensVendaUseCase.execute(id);
        ItensVenda deleted = deletarItensVendaUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "item deletado com sucesso");
        response.put("item" , itensVendaResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }

}
