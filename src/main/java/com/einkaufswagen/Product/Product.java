package com.einkaufswagen.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String productName;

     @Column(name = "price")
    private Double productPrice;

     @Column(name = "description")
    private String productDescription;





}
