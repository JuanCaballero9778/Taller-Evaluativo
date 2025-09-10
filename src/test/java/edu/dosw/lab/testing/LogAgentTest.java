package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import edu.dosw.lab.solid.Category;
import edu.dosw.lab.solid.LogAgent;
import edu.dosw.lab.solid.Product;


class LogAgentTest {

    @Test
    void testShouldShowMessageLog() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        Product product = new Product("Xbox One S", 2000000, 10, Category.TECNOLOGIA);
        LogAgent logAgent = new LogAgent();
        logAgent.update(product);

        System.setOut(originalOut);

        String salida = output.toString();
        assertTrue(salida.contains("Producto: Xbox One S -> 10 unidades disponibles"),
            "Debe mostrar mensaje con el stock actual del producto");
    }

    @Test
    void testShouldUpdateStockWithDiferentProduct() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        Product product = new Product("PS5", 2500000, 5, Category.TECNOLOGIA);
        LogAgent logAgent = new LogAgent();
        logAgent.update(product);

        System.setOut(originalOut);

        String salida = output.toString();
        assertTrue(salida.contains("Producto: PS5 -> 5 unidades disponibles"),
            "Debe mostrar el stock correcto aunque cambie el producto");
    }
}

