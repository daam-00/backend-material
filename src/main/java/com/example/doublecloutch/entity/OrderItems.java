package com.example.doublecloutch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @NotNull
    @Column(name = "amount")
    private double amount;

    public OrderItems(Product product, double amount){
        this.product=product;
        this.amount=amount;
    }
}
