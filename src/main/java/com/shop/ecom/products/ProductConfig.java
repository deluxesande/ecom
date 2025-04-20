package com.shop.ecom.products;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shop.ecom.products.model.Product;
import com.shop.ecom.products.repository.ProductRepository;

@Configuration
public class ProductConfig {
        @Bean
        CommandLineRunner commandLineRunner(ProductRepository productRepository) {
                return args -> {
                        Product product1 = new Product("Nike Air Max 90", "Nike Air Max 90", 120.00,
                                        "https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/6a6d1c7f-1b1a-4b1a-8b1a-8b1a8b1a8b1a/air-max-90-shoe-2XjJzK.jpg",
                                        "Shoes", "Nike", "White", "9.5");
                        Product product2 = new Product("Adidas Superstar", "Adidas Superstar", 100.00,
                                        "https://c.static-adidas.com/images/t_PDP_1280_v1/f_auto,q_auto:eco/6a6d1c7f-1b1a-4b1a-8b1a-8b1a8b1a8b1a/superstar-shoe-2XjJzK.jpg",
                                        "Shoes", "Adidas", "Black", "10");
                        Product product3 = new Product("Puma Suede Classic", "Puma Suede Classic", 80.00,
                                        "https://c.static-puma.com/images/t_PDP_1280_v1/f_auto,q_auto:eco/6a6d1c7f-1b1a-4b1a-8b1a-8b1a8b1a8b1a/suede-classic-shoe-2XjJzK.jpg",
                                        "Shoes", "Puma", "Blue", "8.5");
                        Product product4 = new Product("New Balance 574", "New Balance 574", 90.00,
                                        "https://c.static-newbalance.com/images/t_PDP_1280_v1/f_auto,q_auto:eco/6a6d1c7f-1b1a-4b1a-8b1a-8b1a8b1a8b1a/574-shoe-2XjJzK.jpg",
                                        "Shoes", "New Balance", "Gray", "9");

                        productRepository.saveAll(List.of(product1, product2, product3, product4));
                };
        }
}
