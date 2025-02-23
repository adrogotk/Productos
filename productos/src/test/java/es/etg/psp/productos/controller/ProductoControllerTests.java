package es.etg.psp.productos.controller;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.etg.psp.productos.data.Producto;
import es.etg.psp.productos.service.ProductoService;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testObtenerTodos() throws Exception {
        // Simulamos que el servicio devuelve una lista de productos
        when(productoService.obtenerTodos()).thenReturn(
                Arrays.asList(new Producto(1L, "Laptop", 1200.00, 10))
        );

        // Hacemos la petición y verificamos el resultado
        mockMvc.perform(get("/productos"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$[0].nombre").value("Laptop"))
            .andExpect(jsonPath("$[0].precio").value(1200.0));
    }
}

