package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


    @ManyToMany
    @JoinTable(
            name="order_grocery_item",
            joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_item_id")

    )
    private List<Item> item;

    private LocalDateTime orderdate;

    private BigDecimal totalprice;
}
