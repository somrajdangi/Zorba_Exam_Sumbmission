package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    String productId;
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_quantity")
    Float productQuantity;

    //many product can have only one type
    //eg rice, vegetable all under grocery

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_type_id")
    ProductType productType;

    //customer to product mapping
    //one customer own many product
    //many product belongs to one customer
    @ManyToMany (cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(
            name="product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    Set<Customer>customerSet;

}


