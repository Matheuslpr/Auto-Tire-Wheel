package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.usecases.clientes.AtualizarClientesUseCase;
import dev.matheus.core.usecases.clientes.BuscarClientesUseCase;
import dev.matheus.core.usecases.clientes.CadastrarClientesUseCase;
import dev.matheus.core.usecases.clientes.ListarClientesUseCase;
import dev.matheus.infrastructure.dto.cliente.ClientesCreateRequest;
import dev.matheus.infrastructure.dto.cliente.ClientesRequest;
import dev.matheus.infrastructure.dto.cliente.ClientesResponse;
import dev.matheus.infrastructure.mapper.cliente.ClientesCreateMapper;
import dev.matheus.infrastructure.mapper.cliente.ClientesEntityMapper;
import dev.matheus.infrastructure.mapper.cliente.ClientesResponseMapper;
import dev.matheus.infrastructure.mapper.cliente.ClientesUpdateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final CadastrarClientesUseCase cadastrarClientesUseCase;
    private final BuscarClientesUseCase buscarClientesUseCase;
    private final AtualizarClientesUseCase atualizarClientesUseCase;
    private final ListarClientesUseCase listarClientesUseCase;
    private final ClientesCreateMapper clientesCreateMapper;
    private final ClientesEntityMapper clientesEntityMapper;
    private final ClientesResponseMapper clientesResponseMapper;
    private final ClientesUpdateMapper clientesUpdateMapper;

    public ClientesController(CadastrarClientesUseCase cadastrarClientesUseCase, BuscarClientesUseCase buscarClientesUseCase, AtualizarClientesUseCase atualizarClientesUseCase, ListarClientesUseCase listarClientesUseCase, ClientesCreateMapper clientesCreateMapper, ClientesEntityMapper clientesEntityMapper, ClientesResponseMapper clientesResponseMapper, ClientesUpdateMapper clientesUpdateMapper) {
        this.cadastrarClientesUseCase = cadastrarClientesUseCase;
        this.buscarClientesUseCase = buscarClientesUseCase;
        this.atualizarClientesUseCase = atualizarClientesUseCase;
        this.listarClientesUseCase = listarClientesUseCase;
        this.clientesCreateMapper = clientesCreateMapper;
        this.clientesEntityMapper = clientesEntityMapper;
        this.clientesResponseMapper = clientesResponseMapper;
        this.clientesUpdateMapper = clientesUpdateMapper;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Clientes listados com sucesso");
        response.put("Clientes" , listarClientesUseCase.execute().stream().map(clientesResponseMapper::toDto).toList());
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientesResponse> findById(@PathVariable Long id){
        Clientes clientes = buscarClientesUseCase.execute(id);
        if(clientes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientesResponseMapper.toDto(clientes));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ClientesCreateRequest request){
        Clientes create = cadastrarClientesUseCase.execute(clientesCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Cliente criado com sucesso");
        response.put("Clientes" , clientesResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id, @RequestBody ClientesRequest request){
        Clientes existing = buscarClientesUseCase.execute(id);
        if(existing == null){
            return ResponseEntity.notFound().build();
        }
        Clientes replace = atualizarClientesUseCase.execute(clientesUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Cliente criado com sucesso");
        response.put("Clientes" , clientesResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

}
