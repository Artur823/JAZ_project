package org.example.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private Double bidPrice;
    private Double bidQuantity;
    private Double askPrice;
    private Double askQuantity;
    private Long timestamp;

    // Getters and Setters
}
