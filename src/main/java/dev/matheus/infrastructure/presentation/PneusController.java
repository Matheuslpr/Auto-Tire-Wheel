package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Pneus;
import dev.matheus.core.usecases.pneus.*;
import dev.matheus.infrastructure.dto.pneu.PneusCreateRequest;
import dev.matheus.infrastructure.dto.pneu.PneusRequest;
import dev.matheus.infrastructure.dto.pneu.PneusResponse;
import dev.matheus.infrastructure.mapper.pneu.PneusCreateMapper;
import dev.matheus.infrastructure.mapper.pneu.PneusResponseMapper;
import dev.matheus.infrastructure.mapper.pneu.PneusUpdateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pneus")
public class PneusController {

    private final CadastrarPneusUseCase cadastrarPneusUseCase;
    private final BuscarPneusUseCase buscarPneusUseCase;
    private final AtualizarPneusUseCase atualizarPneusUseCase;
    private final ListarPneusUseCase listarPneusUseCase;
    private final DeletarPneusUseCase deletarPneusUseCase;
    private final PneusCreateMapper pneusCreateMapper;
    private final PneusResponseMapper pneusResponseMapper;
    private final PneusUpdateMapper pneusUpdateMapper;

    public PneusController(CadastrarPneusUseCase cadastrarPneusUseCase, BuscarPneusUseCase buscarPneusUseCase, AtualizarPneusUseCase atualizarPneusUseCase, ListarPneusUseCase listarPneusUseCase, DeletarPneusUseCase deletarPneusUseCase, PneusCreateMapper pneusCreateMapper, PneusResponseMapper pneusResponseMapper, PneusUpdateMapper pneusUpdateMapper) {
        this.cadastrarPneusUseCase = cadastrarPneusUseCase;
        this.buscarPneusUseCase = buscarPneusUseCase;
        this.atualizarPneusUseCase = atualizarPneusUseCase;
        this.listarPneusUseCase = listarPneusUseCase;
        this.deletarPneusUseCase = deletarPneusUseCase;
        this.pneusCreateMapper = pneusCreateMapper;
        this.pneusResponseMapper = pneusResponseMapper;
        this.pneusUpdateMapper = pneusUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Pneus listados com sucesso");
        response.put("Pneus", listarPneusUseCase.execute().stream().map(pneusResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PneusResponse> findById(@PathVariable Long id){
        Pneus pneus = buscarPneusUseCase.execute(id);
        return ResponseEntity.ok(pneusResponseMapper.toDto(pneus));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody PneusCreateRequest request){
        Pneus create = cadastrarPneusUseCase.execute(pneusCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Pneu cadastrado com sucesso");
        response.put("Pneu", pneusResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@Valid @RequestBody PneusRequest request){
        Pneus existing = buscarPneusUseCase.execute(id);
        Pneus replace = atualizarPneusUseCase.execute(pneusUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Pneu atualizado com sucesso");
        response.put("Pneu", pneusResponseMapper.toDto(replace));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        buscarPneusUseCase.execute(id);
        Pneus deleted = deletarPneusUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Pneu deletado com sucesso");
        response.put("Pneu", pneusResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }
}