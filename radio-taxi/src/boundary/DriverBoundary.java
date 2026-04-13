package boundary;

import control.DriverController;
import java.time.LocalDate;
import java.util.Scanner;

public class DriverBoundary {
    public static void handleRegister(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Cadastro de Motorista ---");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Código VR: ");
        String vr = scanner.nextLine();

        controller.registerDriver(name, cpf, vr, LocalDate.now());
        System.out.println("Motorista registrado com sucesso!");
    }

    public static void handleDeactivate(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Desligamento de Motorista ---");
        System.out.print("Digite o VR do motorista: ");
        String vr = scanner.nextLine();
        controller.deactivateDriver(vr, LocalDate.now());
        System.out.println("Motorista " + vr + " desativado.");
    }
}