package cl.irivera.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import cl.irivera.model.Category;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
    
}