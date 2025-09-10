package edu.dosw.lab.testing;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.MonitoreoStock;
import edu.dosw.lab.solid.Product;
import edu.dosw.lab.solid.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

        monitoreoStock.addProduct(scanner);

        assertTrue(stockService.getProducts().containsKey("banano"));
        assertEquals(20, stockService.getProducts().get("banano").getQuantify());
    }

    @Test
    void testUpdateStockFromInput() {
        Product p = new Product("Arroz", 30000, 50, Category.ALIMENTO);
        stockService.addProduct(p);

        String simulatedInput = "Arroz\n25\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        monitoreoStock.updateStock(scanner);

        assertEquals(25, stockService.getProducts().get("arroz").getQuantify());
    }

    @Test
    void testRunMenuFlow() throws Exception {
        String simulatedInput =
                "1\nManzana\n2000\n10\nALIMENTO\n" +
                "2\nManzana\n5\n" +                  
                "3\n" +                             
                "4\n";                               

        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        monitoreoStock.run();

        assertTrue(stockService.getProducts().containsKey("manzana"));
        assertEquals(5, stockService.getProducts().get("manzana").getQuantify());
    }
}
