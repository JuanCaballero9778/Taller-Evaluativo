package edu.dosw.lab.solid;
import org.springframework.stereotype.Component;

/**
 * Clase que maneja cuado u producto se añade o se actualiza su cantidad.
 */
@Component
public class LogAgent implements StockObserver {

    @Override
    public void update(Product product) {
        System.out.println("Producto: " + product.getName() + " -> " + product.getQuantify() + " unidades disponibles");
    }
 
}
