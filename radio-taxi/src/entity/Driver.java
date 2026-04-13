package entity;

import entity.dataType.Address;
import entity.dataType.Cpf;
import entity.dataType.Phone;

import java.time.LocalDate;

public class Driver {
    private String name;
    private Cpf cpf;
    private String driverLicenseNumber;
    private String licenseCategory;
    private LocalDate licenseExpirationDate;
    private String vrCode;
    private String licensePlate;
    private String vehicleModel;
    private String vehicleManufacturer;
    private String vehicleColor;

    private Address homeAddress;
    private Phone homePhone;
    private Phone mobilePhone;

    private LocalDate joinDate;
    private LocalDate leaveDate;

    public Driver(String name, Cpf cpf, String vrCode, LocalDate joinDate) {
        this.name = name;
        this.cpf = cpf;
        this.vrCode = vrCode;
        this.joinDate = joinDate;
    }

    public String getVrCode() { return vrCode; }
    public LocalDate getLeaveDate() { return leaveDate; }

    public void deactivate(LocalDate date) {
        this.leaveDate = date;
    }
}