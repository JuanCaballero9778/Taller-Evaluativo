package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class StockObserverTest {
    
    static class TestObserver implements StockObserver {
        private boolean updated = false;
        private Product productReceived = null;

        @Override
        public void update(Product product) {
            this.updated = true;
            this.productReceived = product;
        }

        public boolean wasUpdated() {
            return updated;
        }

        public Product getProductReceived() {
            return productReceived;
        }
    }

    @Test
    void testUpdateIsCalled() {
        Product product = new Product("Laptop", 2500, 7, Category.TECNOLOGIA);
        TestObserver observer = new TestObserver();

        observer.update(product);

        assertTrue(observer.wasUpdated(), "El método update debe ser llamado");
        assertEquals(product, observer.getProductReceived(), "El producto recibido debe coincidir con el enviado");
    }
}
