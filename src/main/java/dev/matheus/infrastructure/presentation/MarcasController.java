package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Marcas;
import dev.matheus.core.usecases.marcas.*;
import dev.matheus.infrastructure.dto.marca.MarcasCreateRequest;
import dev.matheus.infrastructure.dto.marca.MarcasRequest;
import dev.matheus.infrastructure.dto.marca.MarcasResponse;
import dev.matheus.infrastructure.mapper.marca.MarcasCreateMapper;
import dev.matheus.infrastructure.mapper.marca.MarcasResponseMapper;
import dev.matheus.infrastructure.mapper.marca.MarcasUpdateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/marcas")
public class MarcasController {


    private final CadastrarMarcasUseCase cadastrarMarcasUseCase;
    private final BuscarMarcasUseCase buscarMarcasUseCase;
    private final ListarMarcasUseCase listarMarcasUseCase;
    private final AtualizarMarcasUseCase atualizarMarcasUseCase;
    private final DeletarMarcasUseCase deletarMarcasUseCase;
    private final MarcasCreateMapper marcasCreateMapper;
    private final MarcasResponseMapper marcasResponseMapper;
    private final MarcasUpdateMapper marcasUpdateMapper;

    public MarcasController(CadastrarMarcasUseCase cadastrarMarcasUseCase, BuscarMarcasUseCase buscarMarcasUseCase, ListarMarcasUseCase listarMarcasUseCase, AtualizarMarcasUseCase atualizarMarcasUseCase, DeletarMarcasUseCase deletarMarcasUseCase, MarcasCreateMapper marcasCreateMapper, MarcasResponseMapper marcasResponseMapper, MarcasUpdateMapper marcasUpdateMapper) {
        this.cadastrarMarcasUseCase = cadastrarMarcasUseCase;
        this.buscarMarcasUseCase = buscarMarcasUseCase;
        this.listarMarcasUseCase = listarMarcasUseCase;
        this.atualizarMarcasUseCase = atualizarMarcasUseCase;
        this.deletarMarcasUseCase = deletarMarcasUseCase;
        this.marcasCreateMapper = marcasCreateMapper;
        this.marcasResponseMapper = marcasResponseMapper;
        this.marcasUpdateMapper = marcasUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Marcas listados com sucesso");
        response.put("Marcas" , listarMarcasUseCase.execute().stream().map(MarcasResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasResponse> findById(@PathVariable Long id){
        Marcas marca = buscarMarcasUseCase.execute(id);
        if(marca == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MarcasResponseMapper.toDto(marca));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody MarcasCreateRequest request){
        Marcas create = cadastrarMarcasUseCase.execute(marcasCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Marca cadastrado com sucesso");
        response.put("Marca" , MarcasResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id, @RequestBody MarcasRequest request){
        Marcas existing = buscarMarcasUseCase.execute(id);
        if(existing == null){
            return ResponseEntity.notFound().build();
        }
        Marcas replace = atualizarMarcasUseCase.execute(marcasUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "marca atualizado com sucesso");
        response.put("marca" , marcasResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id){
        Marcas existing = buscarMarcasUseCase.execute(id);
        if(existing == null) {
            return ResponseEntity.notFound().build();
        }
        Marcas deleted = deletarMarcasUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , ",marca deletado com sucesso");
        response.put("marca" , marcasResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);}

}
