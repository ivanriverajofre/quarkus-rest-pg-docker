package cl.irivera.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import cl.irivera.model.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    
}