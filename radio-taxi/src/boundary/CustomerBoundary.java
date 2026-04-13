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
}