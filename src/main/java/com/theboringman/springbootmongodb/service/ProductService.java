package com.theboringman.springbootmongodb.service;

import com.theboringman.springbootmongodb.model.Product;
import com.theboringman.springbootmongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductWithId(String productId){
        return productRepository.findById(productId).get();
    }

    public Product updateProduct(Product product){

        Product getProductExisting = productRepository.findById(product.getProductId()).get();

        getProductExisting.setProductName(product.getProductName());
        getProductExisting.setDescription(product.getDescription());
        getProductExisting.setQuantity(product.getQuantity());

        return productRepository.save(getProductExisting);
    }

    public String deleteProduct(String productId){
        productRepository.deleteById(productId);
        return productId+" was deleted";
    }
}
