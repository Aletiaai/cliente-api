

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

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan@example.com");
        cliente.setTelefono("1234567890");
    }

    @Test
    void testGetAllClientes() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.getAllClientes();
        assertEquals(1, result.size());
        assertEquals("Juan Pérez", result.get(0).getNombre());

        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void testGetClienteById() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.getClienteById(1L);
        assertTrue(result.isPresent());
        assertEquals("Juan Pérez", result.get().getNombre());

        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateCliente() {
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.createCliente(cliente);
        assertNotNull(result);
        assertEquals("Juan Pérez", result.getNombre());

        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testUpdateCliente() {
        when(clienteRepository.existsById(1L)).thenReturn(true);
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente updated = clienteService.updateCliente(1L, cliente);
        assertNotNull(updated);
        assertEquals("Juan Pérez", updated.getNombre());

        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testDeleteCliente() {
        when(clienteRepository.existsById(1L)).thenReturn(true);
        doNothing().when(clienteRepository).deleteById(1L);

        assertDoesNotThrow(() -> clienteService.deleteCliente(1L));

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
