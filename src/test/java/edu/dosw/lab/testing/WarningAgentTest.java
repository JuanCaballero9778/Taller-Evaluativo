package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.Product;
import edu.dosw.lab.solid.WarningAgent;

class WarningAgentTest {
    @Test
    void testShouldPassWithUpdate(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        Product product = new Product("Carne molida", 13450, 2, Category.ALIMENTO);
        WarningAgent agent = new WarningAgent();
        agent.update(product);

        System.setOut(originalOut);

        String exit = output.toString();
        assertTrue(exit.contains("Alerta!!! El stock del producto: Carne molida es muy bajo, solo quedan 2 unidades"),
            "Debe mostrar alerta de stock bajo");
    }

    @Test
    void testSinAlertaStockSuficiente() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        Product product = new Product("Arroz", 5000, 10, Category.ALIMENTO);
        WarningAgent agent = new WarningAgent();
        agent.update(product);

        System.setOut(originalOut);

        String exit = output.toString();
        assertTrue(exit.isEmpty(), "No debe mostrar alerta si el stock es suficiente");
    }
}
