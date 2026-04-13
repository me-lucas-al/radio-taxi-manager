package entity;

import entity.dataType.Address;
import entity.dataType.Cnh; // Import novo
import entity.dataType.Cpf;
import entity.dataType.Phone;
import java.time.LocalDate;

public class Driver {
    private String name;
    private Cpf cpf;
    private String vrCode;
    private Cnh cnh;
    private Vehicle vehicle;
    private Address homeAddress;
    private Phone mobilePhone;
    private LocalDate joinDate;
    private LocalDate leaveDate;

    public Driver(String name, Cpf cpf, String vrCode, LocalDate joinDate,
                  Cnh cnh, Vehicle vehicle, Address address, Phone phone) {
        this.name = name;
        this.cpf = cpf;
        this.vrCode = vrCode;
        this.joinDate = joinDate;
        this.cnh = cnh;
        this.vehicle = vehicle;
        this.homeAddress = address;
        this.mobilePhone = phone;
    }

    public String getVrCode() { return vrCode; }
    public Cpf getCpf() { return cpf; }
    public LocalDate getLeaveDate() { return leaveDate; }
    public String getName() { return name; }
    public Cnh getCnh() { return cnh; }
    public Vehicle getVehicle() { return vehicle; }

    public void deactivate(LocalDate date) {
        this.leaveDate = date;
    }
}