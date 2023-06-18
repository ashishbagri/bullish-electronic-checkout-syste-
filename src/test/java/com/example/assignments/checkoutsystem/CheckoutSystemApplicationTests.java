package com.example.assignments.checkoutsystem;

import com.example.assignments.checkoutsystem.model.Product;
import com.example.assignments.checkoutsystem.repo.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  Create a new product
 * • Remove a product
 * • Add discount deals for products (Example: Buy 1 get 50% off the second)
 * Customer Operations
 * • Add and remove products to and from a basket
 * • Calculate a receipt of items, including all purchases, deals applied and total price
 */
@SpringBootTest
class CheckoutSystemApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testCreateNewProduct() {

		Product product = Product.of("DUMMY", 10.0);
		Product saved = productRepository.save(product);
		Assertions.assertTrue(product.equals(saved));
	}
}
