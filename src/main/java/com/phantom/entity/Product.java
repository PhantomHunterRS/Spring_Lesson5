package com.phantom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;

    public Product(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }
}
