package com.example.controller;

import com.example.entity.Cart;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/addToCart")
    public String saveToCart(@RequestBody Cart cart){

        if(cart!=null){
            cartService.saveCart(cart);
        }

        return "cartSaved";
    }


}
