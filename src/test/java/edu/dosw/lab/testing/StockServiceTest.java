package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.Product;
import edu.dosw.lab.solid.StockObserver;
import edu.dosw.lab.solid.StockService;

import java.util.*;


class StockServiceTest {

    static class TestObserver implements StockObserver {
        private boolean notified = false;
        private Product lastProduct = null;

        @Override
        public void update(Product product) {
            this.notified = true;
            this.lastProduct = product;
        }

        public boolean wasNotified() {
            return notified;
        }

        public Product getLastProduct() {
            return lastProduct;
        }
    }

    @Test
    void testAddProductStores() {
        TestObserver observer = new TestObserver();
        StockService stockService = new StockService(List.of(observer));

        Product product = new Product("MackBook", 2500000, 5, Category.TECNOLOGIA);
        stockService.addProduct(product);

        assertTrue(stockService.getProducts().containsKey("mackbook"));
        assertEquals(product, stockService.getProducts().get("mackbook"));
    }

    @Test
    void testAddProductNotifiesObservers() {
        TestObserver observer = new TestObserver();
        StockService stockService = new StockService(List.of(observer));

        Product product = new Product("Sushi", 3000000, 10, Category.ALIMENTO);
        stockService.addProduct(product);

        assertTrue(observer.wasNotified());
        assertEquals(product, observer.getLastProduct());
    }

    @Test
    void testUpdateStockUpdatesQuantityAndNotifiesObservers() {
        TestObserver observer = new TestObserver();
        StockService stockService = new StockService(List.of(observer));

        Product product = new Product("Camisa", 50000, 3, Category.ROPA);
        stockService.addProduct(product);

        stockService.updateStock("Camisa", 8);

        assertEquals(8, product.getQuantify());
        assertTrue(observer.wasNotified());
        assertEquals(product, observer.getLastProduct());
    }

}
