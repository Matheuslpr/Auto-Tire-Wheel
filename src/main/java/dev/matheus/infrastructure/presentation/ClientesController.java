package dev.matheus.infrastructure.presentation;

import dev.matheus.core.entities.Clientes;
import dev.matheus.core.usecases.clientes.*;
import dev.matheus.infrastructure.dto.cliente.ClientesCreateRequest;
import dev.matheus.infrastructure.dto.cliente.ClientesRequest;
import dev.matheus.infrastructure.dto.cliente.ClientesResponse;
import dev.matheus.infrastructure.mapper.cliente.ClientesCreateMapper;
import dev.matheus.infrastructure.mapper.cliente.ClientesResponseMapper;
import dev.matheus.infrastructure.mapper.cliente.ClientesUpdateMapper;
import jakarta.validation.Valid;
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
    private final DeletarClientesUseCase deletarClientesUseCase;
    private final FiltrarDocumentoClientesUsecase filtrarDocumentoClientesUsecase;
    private final ClientesCreateMapper clientesCreateMapper;
    private final ClientesResponseMapper clientesResponseMapper;
    private final ClientesUpdateMapper clientesUpdateMapper;

    public ClientesController(CadastrarClientesUseCase cadastrarClientesUseCase, BuscarClientesUseCase buscarClientesUseCase, AtualizarClientesUseCase atualizarClientesUseCase, ListarClientesUseCase listarClientesUseCase, DeletarClientesUseCase deletarClientesUseCase, FiltrarDocumentoClientesUsecase filtrarDocumentoClientesUsecase, ClientesCreateMapper clientesCreateMapper, ClientesResponseMapper clientesResponseMapper, ClientesUpdateMapper clientesUpdateMapper) {
        this.cadastrarClientesUseCase = cadastrarClientesUseCase;
        this.buscarClientesUseCase = buscarClientesUseCase;
        this.atualizarClientesUseCase = atualizarClientesUseCase;
        this.listarClientesUseCase = listarClientesUseCase;
        this.deletarClientesUseCase = deletarClientesUseCase;
        this.filtrarDocumentoClientesUsecase = filtrarDocumentoClientesUsecase;
        this.clientesCreateMapper = clientesCreateMapper;
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
        return ResponseEntity.ok(clientesResponseMapper.toDto(clientes));
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<ClientesResponse> findByDocumento(@PathVariable String numeroDocumento) {
        Clientes cliente = filtrarDocumentoClientesUsecase.execute(numeroDocumento);
        return ResponseEntity.ok(clientesResponseMapper.toDto(cliente));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ClientesCreateRequest request){
        Clientes create = cadastrarClientesUseCase.execute(clientesCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Cliente cadastrado com sucesso");
        response.put("Cliente" , clientesResponseMapper.toDto(create));
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replace(@PathVariable Long id,@Valid @RequestBody ClientesRequest request){
        Clientes existing = buscarClientesUseCase.execute(id);
        Clientes replace = atualizarClientesUseCase.execute(clientesUpdateMapper.merge(existing, request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem" , "Cliente atualizado com sucesso");
        response.put("Cliente" , clientesResponseMapper.toDto(replace));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        buscarClientesUseCase.execute(id);
        Clientes deleted = deletarClientesUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Cliente deletado com sucesso");
        response.put("Cliente", clientesResponseMapper.toDto(deleted));
        return ResponseEntity.ok(response);
    }
}
