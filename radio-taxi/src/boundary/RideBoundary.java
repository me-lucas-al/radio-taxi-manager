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

    public static void handleViewMenu(Scanner scanner, RideController controller) {
        System.out.println("\n--- MENU DE CORRIDAS ---");
        System.out.println("1. Ver Todas");
        System.out.println("2. Apenas Pendentes (Aguardando)");
        System.out.println("3. Apenas Concluídas (Tripuladas)");
        System.out.println("4. Apenas Canceladas");
        System.out.print("Escolha: ");
        int op = Integer.parseInt(scanner.nextLine());

        List<Ride> list = switch (op) {
            case 2 -> controller.getPendingRides();
            case 3 -> controller.getCompletedRides();
            case 4 -> controller.getCancelledRides();
            default -> controller.getAllRides();
        };

        System.out.println("\n--- RESULTADO ---");
        if (list.isEmpty()) System.out.println("Nenhum registro encontrado.");
        for (Ride r : list) {
            System.out.println("Status: " + r.getStatus() + " | Endereço: " + r.getPickupAddress());
        }
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
    public static void handleUpdateStatus(Scanner scanner, RideController controller) {
        List<Ride> activeRides = controller.getPendingRides();
        if (activeRides.isEmpty()) {
            System.out.println("Não há corridas ativas para atualizar.");
            return;
        }

        System.out.println("\n--- Gerenciar Status da Corrida ---");
        for (int i = 0; i < activeRides.size(); i++) {
            Ride r = activeRides.get(i);
            System.out.println(i + " - Status: " + r.getStatus() + " | Endereço: " + r.getPickupAddress());
        }

        System.out.print("Selecione o índice da corrida: ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index >= activeRides.size()) {
                System.out.println("Índice inválido.");
                return;
            }

            Ride ride = activeRides.get(index);
            System.out.println("Escolha a nova ação:");
            System.out.println("1. Confirmar Aviso ao Motorista");
            System.out.println("2. Confirmar Embarque do Passageiro (Concluir)");
            System.out.println("3. Cancelar Corrida");

            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1 -> {
                    controller.confirmNoticeForRide(ride);
                    System.out.println("Aviso confirmado!");
                }
                case 2 -> {
                    controller.embarkPassengerOnRide(ride);
                    System.out.println("Passageiro embarcado! Corrida concluída.");
                }
                case 3 -> {
                    System.out.print("Motivo (1-Falta de Táxi, 2-Pedido do Passageiro): ");
                    int reason = Integer.parseInt(scanner.nextLine());
                    if (reason == 1) controller.cancelRideDueToNoTaxi(ride);
                    else controller.cancelRideByPassenger(ride);
                    System.out.println("Corrida cancelada.");
                }
                default -> System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite apenas números.");
        } catch (IllegalStateException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}