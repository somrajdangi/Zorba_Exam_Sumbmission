package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventory_category")
@Getter
@Setter
public class InventoryCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    Integer categoryId;
    @Column(name = "category_name")
    String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryCategory")
    List<Inventory> inventoryList;
}
