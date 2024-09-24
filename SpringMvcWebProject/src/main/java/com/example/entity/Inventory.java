package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    Integer inventoryId;
    protected Inventory() {

    }
    public Inventory(String inventoryDescription, Float inventoryPrice, Integer inventoryQuantity, String inventoryName) {
        this.inventoryDescription = inventoryDescription;
        this.inventoryPrice = inventoryPrice;
        this.inventoryQuantity = inventoryQuantity;
        this.inventoryName = inventoryName;
    }



    @Column(name = "inventory_name")
    String inventoryName;

    @Column(name = "inventory_quantity")
    Integer inventoryQuantity;

    @Column(name = "inventory_price")
    Float inventoryPrice;

    @Column(name = "inventory_description")
    String inventoryDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    InventoryCategory inventoryCategory;

    //need to check
//    @Column(name = "inventory_image")
//    String inventoryImage;

}

