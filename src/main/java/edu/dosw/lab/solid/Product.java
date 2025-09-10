package edu.dosw.lab.solid;

/**
 * Clase que maneja los productos 
 */
public class Product {
    private String name;
    private double price;
    private int quantify;
    private Category category;

    public Product(String name, double price, int quantify, Category category){
        this.name = name;
        this.price = price;
        this.quantify = quantify;
        this.category = category;


    }

    /**
     * Getter para los nombres de los productos.
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Getter para los precios de los productos.
     * @return
     */
    public double getPrice(){
        return price;
    }

    /**
     * Getter para la cantidad de productos
     * @return
     */
    public int getQuantify(){
        return quantify;
    }

    /**
     * Setter para la cantidad de productos
     * @param quantify
     */
    public void setQuantify(int quantify){
        this.quantify = quantify;
    }

    /**
     * Getter para la categoria de los productos.
     * @return
     */
    public Category getCategory(){
        return category;
    }
    
}
