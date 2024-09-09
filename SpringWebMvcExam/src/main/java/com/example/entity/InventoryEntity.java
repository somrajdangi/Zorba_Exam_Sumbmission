package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class InventoryEntity {

    @Id

    Integer inventoryId;
    @Column(name = "inventory_name")
    String inventoryName;
    @Column(name = "inventory_quantity")

    Integer inventoryQuantity;
    @Column(name = "inventory_price")
    Float inventoryPrice;
    @Column(name = "inventory_description")

    String inventoryDescription;


    //need to check
    @Column(name = "inventory_image")

    String inventoryImage;
}
