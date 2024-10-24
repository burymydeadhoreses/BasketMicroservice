package io.github.burymydeadhoreses.basketmicroservice.controllers;

import io.github.burymydeadhoreses.basketmicroservice.entities.Basket;
import io.github.burymydeadhoreses.basketmicroservice.entities.Product;
import io.github.burymydeadhoreses.basketmicroservice.services.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/basket")
@AllArgsConstructor
public class BasketController {
    private BasketService basketService;

    @GetMapping("/{id}")
    public List<Product> list(@PathVariable UUID id) {
        return basketService.list(id);
    }

    @PostMapping
    public void add(@RequestBody Basket basket) {
        var productIds = basket.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        basketService.add(basket.getId(), productIds);
    }

    @DeleteMapping
    public void delete(@RequestBody Basket basket) {
        var productIds = basket.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        basketService.delete(basket.getId(), productIds);
    }

    @PutMapping("/{id}")
    public void order(@PathVariable UUID id) {
        basketService.order(id);
    }
}
