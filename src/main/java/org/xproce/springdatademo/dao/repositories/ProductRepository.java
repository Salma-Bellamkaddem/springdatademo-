package org.xproce.springdatademo.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.springdatademo.dao.entities.Product;

import java.util.List;

public interface ProductRepository  extends JpaRepository <Product, Long> {
    public List<Product> findByName(String name);
    public List<Product> findByDescription(String description);
    public List<Product> findByPrice(Double price);


}
