package com.shop.ecom.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ecom.products.model.Product;
import com.shop.ecom.products.repository.ProductRepository;

import jakarta.transaction.Transactional;

import java.util.List; // Add import for List
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        // Name of product must be unique
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());

        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product already exists");
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        // Check if product exists
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("Product with id " + productId + " does not exist");
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, Product product) {
        // Validate if product exists
        Product productToUpdate = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id " + productId +
                        " does not exist"));

        // update the product
        // if the new values are not null and not equal to the old
        if (product.getName() != null && product.getName().length() > 0
                && !product.getName().equals(productToUpdate.getName())) {
            productToUpdate.setName(product.getName());
        }

        if (product.getDescription() != null && product.getDescription().length() > 0
                && !product.getDescription().equals(productToUpdate.getDescription())) {
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != null && product.getPrice() > 0
                && !product.getPrice().equals(productToUpdate.getPrice())) {
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getImageUrl() != null && product.getImageUrl().length() > 0
                && !product.getImageUrl().equals(productToUpdate.getImageUrl())) {
            productToUpdate.setImageUrl(product.getImageUrl());
        }
        if (product.getCategory() != null && product.getCategory().length() > 0
                && !product.getCategory().equals(productToUpdate.getCategory())) {
            productToUpdate.setCategory(product.getCategory());
        }
        if (product.getBrand() != null && product.getBrand().length() > 0
                && !product.getBrand().equals(productToUpdate.getBrand())) {
            productToUpdate.setBrand(product.getBrand());
        }
        if (product.getColor() != null && product.getColor().length() > 0
                && !product.getColor().equals(productToUpdate.getColor())) {
            productToUpdate.setColor(product.getColor());
        }
        if (product.getSize() != null && product.getSize().length() > 0
                && !product.getSize().equals(productToUpdate.getSize())) {
            productToUpdate.setSize(product.getSize());
        }
    }
}
