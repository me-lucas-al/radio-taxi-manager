package entity;

import entity.dataType.Address;
import entity.dataType.Cpf;
import entity.dataType.Phone;
import java.time.LocalDate;

public class Driver {
    private String name;
    private Cpf cpf;
    private String vrCode;
    private String driverLicenseNumber;
    private String licenseCategory;
    private LocalDate licenseExpirationDate;
    private Vehicle vehicle;
    private Address homeAddress;
    private Phone mobilePhone;
    private LocalDate joinDate;
    private LocalDate leaveDate;

    public Driver(String name, Cpf cpf, String vrCode, LocalDate joinDate,
                  String license, String category, LocalDate expiration,
                  Vehicle vehicle, Address address, Phone phone) {
        this.name = name;
        this.cpf = cpf;
        this.vrCode = vrCode;
        this.joinDate = joinDate;
        this.driverLicenseNumber = license;
        this.licenseCategory = category;
        this.licenseExpirationDate = expiration;
        this.vehicle = vehicle;
        this.homeAddress = address;
        this.mobilePhone = phone;
    }

    public String getVrCode() { return vrCode; }
    public Cpf getCpf() { return cpf; }
    public LocalDate getLeaveDate() { return leaveDate; }
    public Vehicle getVehicle() { return vehicle; }
    public String getName() { return name; }

    public void deactivate(LocalDate date) {
        this.leaveDate = date;
    }
}