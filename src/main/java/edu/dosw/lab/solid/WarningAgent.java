package edu.dosw.lab.solid;

import org.springframework.stereotype.Component;

/**
 * Clase que maneja la  alerta cuando cualquier producto se vea afectado generando alertas
 * cuando el stock es muy bajo.
 */
@Component
public class WarningAgent implements StockObserver{
    
    @Override
    public void update(Product product){
        if(product.getQuantify() < 5){
            System.out.println("Alerta!!! El stock del producto: " + product.getName() +
                " es muy bajo, solo quedan " + product.getQuantify() + " unidades.");
        }
    }
}

