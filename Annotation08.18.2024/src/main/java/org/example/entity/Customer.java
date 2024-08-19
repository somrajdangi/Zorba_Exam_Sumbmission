package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
   String custId;
    @Column(name = "cust_name")
    String custName;
    @Column(name = "cust_email")
    String custEmail;
    @Column(name = "cust_mobile")
    Long custMobile;
    @Column(name = "final_product_price")
    Float finalProductPrice;
    //customer and productType mapping
    //one producttype can_belongs to many customer
    //many_customer can_belongs to one procuct type
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_type_id")
    )
    Set<ProductType> productTypeSet;

    //customer to product mapping
    //one customer own many product
    //many product belongs to one customer
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "product",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<Product> productSet;

}
