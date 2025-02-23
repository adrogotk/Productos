package es.etg.psp.productos.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.etg.psp.productos.service.ProductoService;

@EntityScan(basePackages = "es.etg.psp.productos.data")
@ComponentScan(basePackages = {
    "es.etg.psp.productos.controller",
    "es.etg.psp.productos.service" // Asegúrate de incluir este paquete
})
@EnableJpaRepositories(basePackages = "es.etg.psp.productos.data")
@Configuration
public class AppConfig {
   @Bean
    public ProductoService productoService() {
        return new ProductoService();
    }
}
