package edu.dosw.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.MonitoreoStock;
import edu.dosw.lab.solid.Product;
import edu.dosw.lab.solid.StockService;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MonitoreoStockTest {

    private StockService stockService;
    private MonitoreoStock monitoreoStock;

    @BeforeEach
    void setUp() {
        stockService = new StockService(java.util.List.of());
        monitoreoStock = new MonitoreoStock(stockService);
    }

    @Test
    void testAddProductFromInput() {
        String simulatedInput = "Banano\n1500\n20\nALIMENTO\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> {
            var method = MonitoreoStock.class.getDeclaredMethod("addProduct", Scanner.class);
            method.setAccessible(true);
            method.invoke(monitoreoStock, scanner);
        });

        assertTrue(stockService.getProducts().containsKey("banano"));
    }

    @Test
    void testUpdateStockFromInput() {
        Product p = new Product("Arroz", 30000, 50, Category.ALIMENTO);
        stockService.addProduct(p);

        String simulatedInput = "Arroz\n25\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertDoesNotThrow(() -> {
            var method = MonitoreoStock.class.getDeclaredMethod("updateStock", Scanner.class);
            method.setAccessible(true);
            method.invoke(monitoreoStock, scanner);
        });

        assertEquals(25, p.getQuantify());
    }
}
