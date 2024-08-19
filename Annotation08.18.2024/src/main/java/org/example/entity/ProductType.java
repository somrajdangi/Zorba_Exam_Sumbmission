package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "product_type")
@Getter
@Setter
@ToString
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_type_id")
    Integer prodTypeId;
    @Column(name = "product_type")
    String productType;
    @Column(name = "rate")
    Float rate;

    //productType and Customer mapping
    //one producttype can belongs to many customer
    //many customer can belongs to one procuct type
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product",
            joinColumns = @JoinColumn(name = "product_type_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    Set<Customer> customerSet;

    //one productType can have many product
    //one grocery type can have (rice, vegetable, salt) product
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product_type")
    Set<Product> productSet;

}
