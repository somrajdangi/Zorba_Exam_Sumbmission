package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class InventoryCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;
    @Column(name = "category_name")
    String categoryName;

}
