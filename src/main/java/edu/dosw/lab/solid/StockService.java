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

    /**
     * Inyeccion de dependecias.
     * @param observers
     */
    @Autowired
    public StockService(List<StockObserver> observers) {
        this.observers = observers; 
    }

    /**
     * Método que añade un producto segun su nombre y atributos.
     * @param product
     */
    public void addProduct(Product product) {
        String key = product.getName().trim().toLowerCase();
        products.put(key, product);
        notificate(product);
    }

    /**
     * Método que actualiza el stock
     * @param name
     * @param quantify
     */
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

    /**
     * Getter que devuelve un map con los productos.
     * @return
     */
    public Map<String, Product> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    /**
     * Método que notifica segun los observadores.
     * @param product
     */
    private void notificate(Product product) {
        for (StockObserver observer : observers) {
            observer.update(product);
        }
    }
}
