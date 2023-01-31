package com.einkaufswagen.Cart;

import com.einkaufswagen.Product.Product;
import com.einkaufswagen.User.User;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
@Table(name = "tbl_cart")
public class Cart  {

    @Id
    @Column(name = "cart_id")
    private Long id;


    @OneToOne(mappedBy = "cart")
    @Column(name = "user")
    private User user;

    @OneToMany(mappedBy ="cart")
    private List<Product> products;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
