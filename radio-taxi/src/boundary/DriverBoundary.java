package boundary;

import control.DriverController;
import entity.Driver;
import entity.Vehicle;
import entity.dataType.Address;
import entity.dataType.Cnh;
import entity.dataType.Cpf;
import entity.dataType.Phone;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DriverBoundary {
    public static void handleRegister(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Cadastro Completo de Motorista ---");

        System.out.print("Nome: "); String name = scanner.nextLine();
        System.out.print("CPF: "); Cpf cpf = new Cpf(scanner.nextLine());
        System.out.print("Código VR: "); String vr = scanner.nextLine();

        System.out.print("Número da CNH: "); String cnhNum = scanner.nextLine();
        System.out.print("Categoria (A/B/D): "); String cat = scanner.nextLine();
        System.out.print("Validade (AAAA-MM-DD): ");
        LocalDate exp = LocalDate.parse(scanner.nextLine());

        System.out.print("Placa: "); String plate = scanner.nextLine();
        System.out.print("Modelo: "); String model = scanner.nextLine();
        System.out.print("Marca: "); String manuf = scanner.nextLine();
        System.out.print("Cor: "); String color = scanner.nextLine();
        Vehicle vehicle = new Vehicle(plate, model, manuf, color);

        System.out.print("Rua: "); String street = scanner.nextLine();
        Address addr = new Address(street, "S/N", "", "Bairro", "Cidade", "Estado");
        System.out.print("Telefone: "); Phone phone = new Phone(scanner.nextLine());

        Cnh cnh = new Cnh(cnhNum, cat, exp);
        controller.registerDriver(name, cpf, vr, LocalDate.now(), cnh, vehicle, addr, phone);

        System.out.println("Motorista e Veículo registrados com sucesso!");
    }

    public static void handleViewMenu(Scanner scanner, DriverController controller) {
        System.out.println("\n--- MENU DE MOTORISTAS ---");
        System.out.println("1. Listar Todos");
        System.out.println("2. Apenas Ativos");
        System.out.println("3. Apenas Desativados");
        System.out.print("Escolha: ");

        try {
            int op = Integer.parseInt(scanner.nextLine());

            List<Driver> list = switch (op) {
                case 2 -> controller.getActiveDrivers();
                case 3 -> controller.getAllDrivers().stream().filter(d -> d.getLeaveDate() != null).toList();
                default -> controller.getAllDrivers();
            };

            System.out.println("\n--- RESULTADO ---");
            if (list.isEmpty()) {
                System.out.println("Nenhum motorista encontrado.");
            } else {
                for (Driver d : list) {
                    String status = (d.getLeaveDate() == null) ? "ATIVO" : "DESLIGADO";
                    System.out.println("VR: " + d.getVrCode() + " | Nome: " + d.getName() + " | CPF: " + d.getCpf() + " | Status: " + status);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Opção inválida.");
        }
    }

    public static void handleDeactivate(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Desligamento de Motorista ---");
        System.out.print("Digite o VR do motorista: ");
        String vr = scanner.nextLine();
        try {
            controller.deactivateDriver(vr, LocalDate.now());
            System.out.println("Motorista " + vr + " desativado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}