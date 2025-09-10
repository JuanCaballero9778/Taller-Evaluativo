package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.Product;

import edu.dosw.lab.solid.ProductFactory;

class ProductFactoryTest {

    @Test
    void testCreateProduct() {
        Product product = ProductFactory.createProduct(Category.TECNOLOGIA,"Xbox One S", 1000000, 10);

        assertNotNull(product, "El producto no debe ser nulo");
        assertEquals("Xbox One S", product.getName());
        assertEquals(1000000, product.getPrice());
        assertEquals(10, product.getQuantify());
        assertEquals(Category.TECNOLOGIA, product.getCategory());
    }
}
