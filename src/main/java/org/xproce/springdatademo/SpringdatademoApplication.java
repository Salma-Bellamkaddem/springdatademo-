package org.xproce.springdatademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproce.springdatademo.dao.entities.Product;
import org.xproce.springdatademo.dao.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class SpringdatademoApplication implements CommandLineRunner {
@Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(SpringdatademoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //save
        Product product = new Product(1,"name1","description1",12.40);
        Product product1 = new Product(2,"name1","description1",10.40);
        Product product2Delete = new Product(3,"name3","description3",15.40);
        Product product3Update = new Product(4,"name4","description4",12.40);
        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2Delete);
        productRepository.save(product3Update);
//read
     Product  productById = productRepository.findById( 1L).get();
        System.out.println(productById);
//methode 2
        List <Product> products =   productRepository.findAll();
        products.forEach(productFromList -> {

            System.out.println(productFromList.toString());

        });
        //update


        Product productUpdatedById = productRepository.findById(4L).get();
        System.out.println(productUpdatedById);
        product3Update.setDescription("description4");
        productRepository.save(product3Update);
        productUpdatedById = productRepository.findById(3L).get();
        System.out.println(productUpdatedById);



        //Delete
        productRepository.save(product2Delete);
        try {
            System.out.println(productRepository.findById(2L).get());
        } catch (Exception exception) {
            System.out.println("The Product has been deleted");
        }
    }
}
