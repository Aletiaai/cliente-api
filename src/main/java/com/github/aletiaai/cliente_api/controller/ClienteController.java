package com.github.aletiaai.cliente_api.controller;

import com.github.aletiaai.cliente_api.model.Cliente;
import com.github.aletiaai.cliente_api.service.ClienteService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    //@Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Extraer un cliente con ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    // Actualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente updatedCliente = clienteService.updateCliente(id, cliente);
            return ResponseEntity.ok(updatedCliente);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Borrar cliente con su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
