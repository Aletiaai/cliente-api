package com.github.aletiaai.cliente_api.service;

import com.github.aletiaai.cliente_api.model.Cliente;
import com.github.aletiaai.cliente_api.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    //@Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente not found with ID: " + id);
        }
    }

    @Override
    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente not found with ID: " + id);
        }
    }
}
