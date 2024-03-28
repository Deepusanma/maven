package org.mobin.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class FirstApplication implements CommandLineRunner {
    @Autowired
    ProductDao productDao;


    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(FirstApplication.class, args);
        Product product1 = (Product) context.getBean("product");
        product1.user.setEmail("info@gmail.com");
        System.out.println(product1.user.getEmail());
    }

    @Override
    public void run(String... args) throws Exception {
        productDao.persist();
    }
}