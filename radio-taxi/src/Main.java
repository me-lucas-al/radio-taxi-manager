import boundary.CustomerBoundary;
import boundary.DriverBoundary;
import boundary.RideBoundary;
import control.CustomerController;
import control.DriverController;
import control.RideController;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerController customerCtrl = new CustomerController();
    private static final DriverController driverCtrl = new DriverController();
    private static final RideController rideCtrl = new RideController();

    void main() {
        int option = -1;

        while (option != 0) {
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> CustomerBoundary.handleRegister(scanner, customerCtrl);
                    case 2 -> DriverBoundary.handleRegister(scanner, driverCtrl);
                    case 3 -> RideBoundary.handleRequest(scanner, rideCtrl, customerCtrl);
                    case 4 -> RideBoundary.handleDispatch(scanner, rideCtrl);
                    case 5 -> DriverBoundary.handleDeactivate(scanner, driverCtrl);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida! Digite um número de 0 a 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Entrada inválida. Por favor, digite apenas números.");
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== MAR & SOL - SISTEMA DE RÁDIO TÁXI ===");
        System.out.println("1. Novo Cliente");
        System.out.println("2. Novo Motorista");
        System.out.println("3. Pedir Corrida");
        System.out.println("4. Atribuir Táxi (Dispatch)");
        System.out.println("5. Desativar Motorista");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }
}