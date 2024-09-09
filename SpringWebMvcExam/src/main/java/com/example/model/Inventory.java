package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Inventory {
    String category, name, quantity, price, description;
    String image;
}
