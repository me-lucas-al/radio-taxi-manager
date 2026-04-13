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
                    case 6 -> CustomerBoundary.handleViewMenu(scanner, customerCtrl);
                    case 7 -> DriverBoundary.handleViewMenu(scanner, driverCtrl);
                    case 8 -> RideBoundary.handleViewMenu(scanner, rideCtrl);
                    case 9 -> RideBoundary.handleUpdateStatus(scanner, rideCtrl);   
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
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
        System.out.println("1. Novo Cliente         | 6. Menu Clientes (Ver)");
        System.out.println("2. Novo Motorista       | 7. Menu Motoristas (Ver)");
        System.out.println("3. Pedir Corrida        | 8. Menu Corridas (Ver)");
        System.out.println("4. Atribuir Táxi (Disp) | 9. Atualizar Status Corrida");
        System.out.println("5. Desativar Motorista  | 0. Sair");
        System.out.print("Escolha: ");
    }
}