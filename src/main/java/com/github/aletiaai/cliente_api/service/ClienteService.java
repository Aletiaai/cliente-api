package com.github.aletiaai.cliente_api.service;

import com.github.aletiaai.cliente_api.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes(); // Método para obtener una lista de todos los clientes.
    Optional<Cliente> getClienteById(Long id); // Método para obtener un cliente usando su ID.
    Cliente createCliente(Cliente cliente); // Método para crear un nuevo cliente.
    Cliente updateCliente(Long id, Cliente cliente); // Método para actualizar un cliente existente.
    void deleteCliente(Long id); // Método para eliminar un cliente usando su ID.
}
