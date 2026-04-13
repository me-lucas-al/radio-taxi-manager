package boundary;

import control.CustomerController;
import control.RideController;
import entity.Customer;
import entity.Ride;
import entity.dataType.Phone;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class RideBoundary {
    public static void handleRequest(Scanner scanner, RideController rideCtrl, CustomerController custCtrl) {
        System.out.println("\n--- Solicitação de Corrida ---");
        System.out.print("Nome do Cliente: ");
        String name = scanner.nextLine();
        Customer customer = custCtrl.registerCustomer(name);

        System.out.print("Endereço (Rua): ");
        String street = scanner.nextLine();
        System.out.print("Bairro de Destino: ");
        String neighborhood = scanner.nextLine();
        System.out.print("Telefone: ");
        Phone phone = new Phone(scanner.nextLine());

        rideCtrl.requestRide(customer, street, neighborhood, LocalDateTime.now(), phone);
        System.out.println("Corrida solicitada!");
    }

    public static void handleDispatch(Scanner scanner, RideController controller) {
        List<Ride> pending = controller.getPendingRides();
        if (pending.isEmpty()) {
            System.out.println("Nenhuma corrida pendente.");
            return;
        }

        System.out.println("\n--- Corridas Pendentes ---");
        for (int i = 0; i < pending.size(); i++) {
            System.out.println(i + " - " + pending.get(i).getStatus());
        }

        System.out.print("Selecione o índice: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Informe o VR do Táxi: ");
        String vr = scanner.nextLine();

        controller.assignTaxiToRide(pending.get(index), vr);
        System.out.println("Táxi atribuído!");
    }
}