package edu.dosw.lab.solid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Clase que maneja el servicio del stock.
 */
@Service
public class StockService {

    private final Map<String, Product> products = new HashMap<>();
    private final List<StockObserver> observers;

    @Autowired
    public StockService(List<StockObserver> observers) {
        this.observers = observers; 
    }

    public void addProduct(Product product) {
        String key = product.getName().trim().toLowerCase();
        products.put(key, product);
        notificate(product);
    }

    public void updateStock(String name, int quantify) {
        String key = name.trim().toLowerCase();
        Product product = products.get(key);
        if (product != null) {
            product.setQuantify(quantify);
            notificate(product);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }


    public Map<String, Product> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    private void notificate(Product product) {
        for (StockObserver observer : observers) {
            observer.update(product);
        }
    }
}
