package io.github.burymydeadhoreses.basketmicroservice.repositories;

import io.github.burymydeadhoreses.basketmicroservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>  {
}
