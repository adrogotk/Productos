package es.etg.psp.productos.service;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import es.etg.psp.productos.data.Producto;
import es.etg.psp.productos.data.ProductoRepository;

public class ProductoServiceTests {
    // crea un objeto simulado de ProductoRepository.
    @Mock
    private ProductoRepository productoRepository;

    //inyecta el mock en ProductoService
    @InjectMocks
    private ProductoService productoService;

    //El metodo debe ejecutarse antes de cada "@test" method de la clase
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    } 

    @Test
    void testObtenerTodos() {
        //define el comportamiento del mock.
        when(productoRepository.findAll()).thenReturn(
            Arrays.asList(new Producto(1L, "Laptop", 1200.00, 10)));

        List<Producto> productos = productoService.obtenerTodos();

        assertFalse(productos.isEmpty());
        assertEquals(1, productos.size());
        assertEquals("Laptop", productos.get(0).getNombre());
    }
}
