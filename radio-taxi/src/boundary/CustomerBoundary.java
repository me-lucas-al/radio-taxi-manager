package boundary;

import control.CustomerController;
import entity.Customer;
import java.util.Scanner;

public class CustomerBoundary {
    public static void handleRegister(Scanner scanner, CustomerController controller) {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        Customer c = controller.registerCustomer(name);
        System.out.println("Cliente cadastrado com sucesso! Código: " + c.getCode());
    }
    public static void handleViewMenu(Scanner scanner, CustomerController controller) {
        System.out.println("\n--- MENU DE CLIENTES ---");
        System.out.println("1. Listar Todos");
        System.out.print("Escolha: ");
        int op = Integer.parseInt(scanner.nextLine());

        if (op == 1) {
            System.out.println("\n--- LISTA DE CLIENTES ---");
            for (Customer c : controller.getAllCustomers()) {
                System.out.println("Código: " + c.getCode() + " | Nome: " + c.getName());
            }
        }
    }
}