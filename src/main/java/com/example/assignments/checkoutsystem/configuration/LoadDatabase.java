package com.example.assignments.checkoutsystem.configuration;

import com.example.assignments.checkoutsystem.model.Product;
import com.example.assignments.checkoutsystem.model.Role;
import com.example.assignments.checkoutsystem.model.User;
import com.example.assignments.checkoutsystem.repo.ProductRepository;
import com.example.assignments.checkoutsystem.repo.RoleRepository;
import com.example.assignments.checkoutsystem.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            Role ADMIN = new Role();
            ADMIN.setName("ADMIN");
            Role CUSTOMER = new Role();
            CUSTOMER.setName("CUSTOMER");
            logger.info("Adding role : "+roleRepository.save(ADMIN));
            logger.info("Adding role : "+roleRepository.save(CUSTOMER));

            logger.info("Adding role : "+userRepository.save(new User("AdminUser", ADMIN)));
            logger.info("Adding role : "+userRepository.save(new User("Customer1", CUSTOMER)));
            logger.info("Adding role : "+userRepository.save(new User("Customer2", CUSTOMER)));

            logger.info("PreLoading "+productRepository.save(Product.createProduct("Product1", Double.valueOf(20.25))));
            logger.info("PreLoading "+productRepository.save(Product.createProduct("Product1", Double.valueOf(100.00))));
        };
    }
}
