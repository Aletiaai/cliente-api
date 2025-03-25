package com.github.aletiaai.cliente_api.service;

import com.github.aletiaai.cliente_api.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}
