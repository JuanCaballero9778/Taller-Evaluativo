package edu.dosw.lab.solid;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MonitoreoStock implements CommandLineRunner {

    private final StockService stockService;

    public MonitoreoStock(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MONITOREO DE STOCK ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar stock");
            System.out.println("3. Ver productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addProduct(scanner);
                    break;
                case "2":
                    updateStock(scanner);
                    break;
                case "3":
                    showProducts();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }

        System.out.println("¡Gracias por usar el sistema de monitoreo de stock!");
    }

    public void addProduct(Scanner scanner) {
        System.out.print("Nombre del producto: ");
        String name = scanner.nextLine();

        System.out.print("Precio: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Cantidad: ");
        int quantify = Integer.parseInt(scanner.nextLine());

        System.out.println("Categorías disponibles:");
        for (Category c : Category.values()) {
            System.out.println("- " + c);
        }

        System.out.print("Categoría: ");
        String catInput = scanner.nextLine().toUpperCase();
        Category category;
        try {
            category = Category.valueOf(catInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Categoría inválida. Se usará ALIMENTO por defecto.");
            category = Category.ALIMENTO;
        }

        Product producto = new Product(name, price, quantify, category);
        stockService.addProduct(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void updateStock(Scanner scanner) {
        System.out.print("Nombre del producto a actualizar: ");
        String name = scanner.nextLine();

        System.out.print("Nueva cantidad: ");
        int quantify = Integer.parseInt(scanner.nextLine());

        stockService.updateStock(name, quantify);
    }

    private void showProducts() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        stockService.getProducts().values().forEach(p -> {
            System.out.println(p.getName() + " | Cantidad: " + p.getQuantify() +
                    " | Precio: " + p.getPrice() +
                    " | Categoría: " + p.getCategory());
        });
    }
}
