package es.etg.psp.productos.data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//Configura un entorno de prueba para JPA. Pruebas de integración (verifican cómo interactúan los diferentes componentes de la aplicación)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoRepositoryTests {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void testGuardarYRecuperarProducto() {
        Producto producto = new Producto(null, "Teclado", 50.00, 20);
        productoRepository.save(producto);

        List<Producto> productos = productoRepository.findAll();
        assertFalse(productos.isEmpty());
    }
}
