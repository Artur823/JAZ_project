package org.example.core.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "market_data")
public class MarketData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private Double price;
    private Double volume;
    private String timestamp;


}
