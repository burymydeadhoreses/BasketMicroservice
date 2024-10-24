package io.github.burymydeadhoreses.basketmicroservice.services;

import io.github.burymydeadhoreses.basketmicroservice.entities.Basket;
import io.github.burymydeadhoreses.basketmicroservice.entities.Product;
import io.github.burymydeadhoreses.basketmicroservice.repositories.BasketRepository;
import io.github.burymydeadhoreses.basketmicroservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BasketService {

    private BasketRepository basketRepository;

    private ProductRepository productRepository;

    public List<Product> list(UUID basketId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        return basket.getProducts();
    }

    public void add(UUID basketId, List<UUID> productIds) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        if(basket.isOrdered())
            throw new RuntimeException("Basket is ordered and cannot be changed!");

        List<Product> products = productRepository.findAllById(productIds);
        basket.getProducts().addAll(products);
        basketRepository.save(basket);
    }

    public void delete(UUID basketId, List<UUID> productIds) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        if(basket.isOrdered())
            throw new RuntimeException("Basket is ordered and cannot be changed!");

        basket.getProducts()
                .removeIf(p -> productIds.contains(p.getId()));

        basketRepository.save(basket);
    }

    public void order(UUID id) {
        Basket basket = basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        if(basket.isOrdered())
            throw new RuntimeException("Basket is already ordered");

        basket.setOrdered(true);

        basketRepository.save(basket);
    }
}

