package io.github.burymydeadhoreses.basketmicroservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Basket {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany
    private List<Product> products;

    private boolean isOrdered = false;
}
