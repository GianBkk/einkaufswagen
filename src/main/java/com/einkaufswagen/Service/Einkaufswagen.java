package com.einkaufswagen.Service;


import com.einkaufswagen.Cart.Cart;
import com.einkaufswagen.Cart.CartRepository;
import com.einkaufswagen.Product.Product;
import com.einkaufswagen.User.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Einkaufswagen {

    private final ProductService productService;
    private final UserService userService;

    private final CartRepository cartRepository;

    public Einkaufswagen(ProductService productService, UserService userService, CartRepository cartRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartRepository = cartRepository;
    }


    public Cart addToCart(long userId, long productId){
        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        return Cart.builder()
                .products(products)
                .user(user)
                .build();
    }





}
