package boundary;

import control.DriverController;
import entity.Driver;
import entity.Vehicle;
import entity.dataType.Address;
import entity.dataType.Cpf;
import entity.dataType.Phone;

import java.time.LocalDate;
import java.util.Scanner;

public class DriverBoundary {
    public static void handleRegister(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Cadastro Completo de Motorista ---");

        System.out.print("Nome: "); String name = scanner.nextLine();
        System.out.print("CPF: "); Cpf cpf = new Cpf(scanner.nextLine());
        System.out.print("Código VR: "); String vr = scanner.nextLine();

        System.out.print("CNH: "); String cnh = scanner.nextLine();
        System.out.print("Categoria: "); String cat = scanner.nextLine();
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

        controller.registerDriver(name, cpf, vr, LocalDate.now(),
                cnh, cat, exp, vehicle, addr, phone);

        System.out.println("Motorista e Veículo registrados com sucesso!");
    }
    public static void handleViewAll(DriverController controller) {
        System.out.println("\n--- Lista de Motoristas ---");
        for (Driver d : controller.getAllDrivers()) {
            String status = (d.getLeaveDate() == null) ? "ATIVO" : "DESLIGADO em " + d.getLeaveDate();
            System.out.println("VR: " + d.getVrCode() + " | Nome: " + d.getName() + " | CPF: " + d.getCpf() + " | Status: " + status);
        }
    }

    public static void handleDeactivate(Scanner scanner, DriverController controller) {
        System.out.println("\n--- Desligamento de Motorista ---");
        System.out.print("Digite o VR do motorista: ");
        String vr = scanner.nextLine();
        controller.deactivateDriver(vr, LocalDate.now());
        System.out.println("Motorista " + vr + " desativado.");
    }
}