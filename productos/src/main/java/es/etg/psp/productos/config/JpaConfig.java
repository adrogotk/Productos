package es.etg.psp.productos.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@EntityScan(basePackages = "es.etg.psp.productos.data")
@ComponentScan(basePackages = {
    "es.etg.psp.productos.controller",
    "es.etg.psp.productos.service" // Asegúrate de incluir este paquete
})
@EnableJpaRepositories(basePackages = "es.etg.psp.productos.data")
@Configuration
public class JpaConfig {
    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("es.etg.psp.productos.data"); 
        em.setPackagesToScan("es.etg.psp.productos.controller");
        em.setPackagesToScan("es.etg.psp.productos.services");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.community.dialect.SQLiteDialect"); 
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }
}
