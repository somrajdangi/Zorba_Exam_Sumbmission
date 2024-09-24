package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    Integer cartId;
    @Column(name = "item_name")
    String itemName;
    @Column(name = "item_description")
    String itemDescription;
    @Column(name = "item_quantity")
    Integer itemQuantity;
    @Column(name = "item_price")
    Float itemPrice;
    @Column(name = "category_name")
    String categoryName;

}
