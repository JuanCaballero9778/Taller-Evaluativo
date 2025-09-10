package edu.dosw.lab.solid;

/**
 * Interfaz que permite notificar a objetos sobre cualquier evento (se modifica o se añade) sobre
 * el objeto que están observando.
 */
public interface StockObserver {
    void update(Product product);
}