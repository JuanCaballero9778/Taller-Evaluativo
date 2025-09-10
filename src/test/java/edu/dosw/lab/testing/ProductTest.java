package edu.dosw.lab.testing;
import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ProductTest {
    
    @Test
    void testGetterName(){
        Product product= new Product("xbox one s", 3200000, 12, Category.TECNOLOGIA);
        assertEquals("xbox one s", product.getName(), "El nombre debe ser xbox one s");
    }

    @Test
    void testGetterPrice(){
        Product product= new Product("play station 5", 2200000, 14, Category.TECNOLOGIA);
        assertEquals(2200000, product.getPrice());
    }

    @Test
    void testGetterQuantify(){
        Product product= new Product("Pasta", 17000, 13, Category.ALIMENTO);
        assertEquals(13, product.getQuantify());
    }

    @Test
    void testSetterQuantify(){
        Product product= new Product("heineken", 4200, 56, Category.BEBIDA);
        assertEquals(56, product.getQuantify());

        product.setQuantify(78);
        assertEquals(78, product.getQuantify());
    }

    @Test
    void testGetterCategory(){
        Product product= new Product("Hot wheels", 15000, 3, Category.JUGUETE);
        assertEquals(Category.JUGUETE, product.getCategory());
    }

    @Test
    void testConstructorNotNull() {
        Product product = new Product( "Mouse", 53400, 11, Category.TECNOLOGIA);
        assertNotNull(product, "El objeto Producto no debería ser nulo después de construirlo");
    }
}
