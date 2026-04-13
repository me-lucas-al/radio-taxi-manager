package entity;

import entity.dataType.Address;
import entity.dataType.Phone;

import java.util.UUID;

public class Customer {
    private UUID code;
    private String name;
    private Address address;
    private Phone primaryPhone;
    private Phone secondaryPhone;

    public Customer(String name) {
        this.code = UUID.randomUUID();
        this.name = name;
    }

    public Customer(String name, Address address, Phone primaryPhone, Phone secondaryPhone) {
        this.code = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
    }

    public UUID getCode() { return code; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public void updateAddress(Address address) { this.address = address; }
    public Phone getPrimaryPhone() { return primaryPhone; }
    public void updatePrimaryPhone(Phone primaryPhone) { this.primaryPhone = primaryPhone; }
    public Phone getSecondaryPhone() { return secondaryPhone; }
    public void updateSecondaryPhone(Phone secondaryPhone) { this.secondaryPhone = secondaryPhone; }
}