

import com.github.aletiaai.cliente_api.model.Cliente;
import com.github.aletiaai.cliente_api.repository.ClienteRepository;
import com.github.aletiaai.cliente_api.service.ClienteServiceImpl;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock // Simula el comportamiento de ClienteRepository
    private ClienteRepository clienteRepository;

    @InjectMocks // Inyecta el mock de clienteRepository en ClienteServiceImpl
    private ClienteServiceImpl clienteService;

    private Cliente cliente; // Objeto Cliente para las pruebas

    @BeforeEach // Se ejecuta antes de cada prueba para configurar el objeto cliente
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan@example.com");
        cliente.setTelefono("1234567890");
    }

    @Test // Prueba el método getAllClientes() del servicio
    void testGetAllClientes() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes); // Simula el comportamiento de findAll()

        List<Cliente> result = clienteService.getAllClientes();
        assertEquals(1, result.size()); // Verifica que se devuelva una lista con un elemento
        assertEquals("Juan Pérez", result.get(0).getNombre()); // Verifica el nombre del cliente

        verify(clienteRepository, times(1)).findAll(); // Verifica que findAll() se llame una vez
    }

    @Test // Prueba el método getClienteById() del servicio
    void testGetClienteById() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente)); // Simula findById()

        Optional<Cliente> result = clienteService.getClienteById(1L);
        assertTrue(result.isPresent()); // Verifica que se devuelva un Optional con un cliente
        assertEquals("Juan Pérez", result.get().getNombre()); // Verifica el nombre del cliente

        verify(clienteRepository, times(1)).findById(1L); // Verifica que findById() se llame una vez
    }

    @Test // Prueba el método createCliente() del servicio
    void testCreateCliente() {
        when(clienteRepository.save(cliente)).thenReturn(cliente); // Simula save()

        Cliente result = clienteService.createCliente(cliente);
        assertNotNull(result); // Verifica que el resultado no sea nulo
        assertEquals("Juan Pérez", result.getNombre()); // Verifica el nombre del cliente

        verify(clienteRepository, times(1)).save(cliente); // Verifica que save() se llame una vez
    }

    @Test // Prueba el método updateCliente() del servicio
    void testUpdateCliente() {
        when(clienteRepository.existsById(1L)).thenReturn(true); // Simula existsById()
        when(clienteRepository.save(cliente)).thenReturn(cliente); // Simula save()

        Cliente updated = clienteService.updateCliente(1L, cliente);
        assertNotNull(updated); // Verifica que el resultado no sea nulo
        assertEquals("Juan Pérez", updated.getNombre());

        verify(clienteRepository, times(1)).save(cliente); // Verifica que save() se llame una vez
    }

    @Test // Prueba el método deleteCliente() del servicio
    void testDeleteCliente() {
        when(clienteRepository.existsById(1L)).thenReturn(true); // Simula existsById()
        doNothing().when(clienteRepository).deleteById(1L); // Simula deleteById()

        assertDoesNotThrow(() -> clienteService.deleteCliente(1L)); // Verifica que no se lance una excepción

        verify(clienteRepository, times(1)).deleteById(1L); // Verifica que deleteById() se llame una vez
    }
}
