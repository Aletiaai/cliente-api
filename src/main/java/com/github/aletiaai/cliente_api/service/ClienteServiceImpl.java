package com.github.aletiaai.cliente_api.service;

import com.github.aletiaai.cliente_api.model.Cliente;
import com.github.aletiaai.cliente_api.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica que esta clase es un componente de servicio de Spring
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository; // Repositorio para acceder a la base de datos de clientes

    //@Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository; // Constructor para inyectar el repositorio
    }

    @Override // Implementación del método para obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll(); // Llama al método findAll() del repositorio
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
            cliente.setId(id); // Establece el ID del cliente
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente not found with ID: " + id); // Lanza una excepción si el cliente no existe
        }
    }

    @Override
    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) { // Verifica si el cliente con el ID dado existe
            clienteRepository.deleteById(id); // Llama al método deleteById() del repositorio
        } else {
            throw new RuntimeException("Cliente not found with ID: " + id);
        }
    }
}
