package com.einkaufswagen.Service;

import com.einkaufswagen.Product.Product;
import com.einkaufswagen.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("This Product does not exist!"));
    }

    public Product addProduct(Product product){
        Product newProduct = Product.builder()
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .quantity(product.getQuantity())
                .build();

        return productRepository.save(newProduct);
    }

    public Product editProduct(Product product){
        Product currentProduct = getProductById(product.getId());
        currentProduct.setProductName(product.getProductName());
        currentProduct.setProductPrice(product.getProductPrice());
        currentProduct.setProductDescription(product.getProductDescription());
        return productRepository.save(currentProduct);
    }


    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }



}
