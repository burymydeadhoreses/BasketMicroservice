package io.github.burymydeadhoreses.basketmicroservice.repositories;

import io.github.burymydeadhoreses.basketmicroservice.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasketRepository extends JpaRepository<Basket, UUID> {
}
