package edu.dosw.lab.solid;

import org.springframework.stereotype.Component;

/**
 * Clase para crear los productos.
 */
@Component
public class ProductFactory{

    public static Product createProduct(Category category, String name, double price, int quantify) {
        return new Product(name, price, quantify, category);
    }
}